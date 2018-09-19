package com.zjts.broadband.job.service.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.project.ReqGiftAdd;
import com.zjts.broadband.common.model.req.job.project.ReqGiftQuery;
import com.zjts.broadband.common.model.req.job.project.ReqGiftUse;
import com.zjts.broadband.job.dao.GiftMapper;
import com.zjts.broadband.job.model.Gift;
import com.zjts.broadband.job.service.GiftService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GiftServiceImpl implements GiftService {
    @Autowired
    private GiftMapper giftMapper;

    /*
     * 增加赠品分类
     * */
    @Override
    public APIResponse add(ReqGiftAdd reqGiftAdd) {
        Gift gift = new Gift();
        BeanUtils.copyProperties(reqGiftAdd, gift);
        Integer stock = gift.getStock();
        gift.setAmount(stock.longValue());//给总量赋值
        Integer insert = giftMapper.myInsert(gift);
        if (insert != 2 && insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /*
     * 修改赠品数量
     * */
    @Override
    public APIResponse update(ReqGiftQuery reqGiftQuery) {
        Gift gift = new Gift();
        BeanUtils.copyProperties(reqGiftQuery, gift);
        Integer insert = giftMapper.updateGiftByid(gift);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /*
     * 修改赠品状态，需要传状态值status=？
     * */
    @Override

    public APIResponse delete(ReqGiftQuery reqGiftQuery) {
        Gift gift = new Gift();
        BeanUtils.copyProperties(reqGiftQuery, gift);
        Integer delete = giftMapper.deleteGift(gift);
        if (delete != 1) {
            return APIResponse.error(CodeEnum.DELETE_ERROR);
        }
        return APIResponse.success();
    }

    /*
     * 查询全部赠品
     * */
    @Override
    public APIResponse findAllGift(ReqGiftQuery reqGiftQuery) {
        Page<Gift> page = new Page<Gift>(reqGiftQuery.getCurrentPage(), reqGiftQuery.getPageSize());
        List<Gift> myItems = giftMapper.selectPage(page,
                new EntityWrapper<Gift>()
        );
        if (myItems.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(myItems));
    }

    /*
     * 多条件查询
     * */
    @Override
    public APIResponse findGift(ReqGiftQuery reqGiftQuery) {
        Page<Gift> page = new Page<Gift>(reqGiftQuery.getCurrentPage(), reqGiftQuery.getPageSize());
        Gift gift = new Gift();
        BeanUtils.copyProperties(reqGiftQuery, gift);
        List<Gift> myItems = giftMapper.findGift(page,gift);
        if (myItems.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(myItems));
    }

    /*
     * 导出Excel文件
     * */
    @Override
    public List<Gift> findAllGift2() {
        List<Gift> giftList = giftMapper.selectList(new EntityWrapper<>());

        return giftList;
    }

    /*
    * 调用赠品
    * */
    @Override
    public APIResponse useGift(List<ReqGiftUse> list) {
        for (ReqGiftUse g : list) {
            Integer update= giftMapper.useGift(g.getgId(),g.getOutput());
            if (update != 1) {
                return APIResponse.error(CodeEnum.USE_ERROR);
            }
        }
        return APIResponse.success();
    }

}
