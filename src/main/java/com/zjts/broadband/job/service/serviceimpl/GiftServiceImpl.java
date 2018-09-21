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
        gift.setAmount(stock.intValue());//给总量赋值
        Integer insert = giftMapper.insert(gift);

        return APIResponse.success();
    }

    /*
     * 修改赠品
     * */
    @Override
    public APIResponse update(ReqGiftQuery reqGiftQuery) {
        Gift gift = new Gift();
        BeanUtils.copyProperties(reqGiftQuery, gift);
        gift.setAmount(gift.getOutput() + gift.getStock());
        Integer insert = giftMapper.updateById(gift);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /*
     * 多条件查询
     * */
    @Override
    public APIResponse findGift(ReqGiftQuery reqGiftQuery) {
        Page<Gift> page = new Page<Gift>(reqGiftQuery.getCurrentPage(), reqGiftQuery.getPageSize());
        Gift gift = new Gift();
        BeanUtils.copyProperties(reqGiftQuery, gift);
        EntityWrapper<Gift> ew = new EntityWrapper<Gift>();
        ew.where("1=1"); //完善语法结构
        if (gift.getId() != null && gift.getId() != 0) {
            ew.and().eq("id", gift.getId());
        }
        if (gift.getName() != null && gift.getName() != "") {
            ew.and().like("name", gift.getName());
        }
        if (gift.getStatus() != null ) {
            ew.and().eq("status", gift.getStatus());
        }
        List<Gift> myItems = giftMapper.selectPage(page, ew);
        if (myItems.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(myItems));
    }


    /*
     * 调用赠品
     * */
    @Override
    public APIResponse useGift(List<ReqGiftUse> list) {
        Gift gift = new Gift();
        for (ReqGiftUse g : list) {
            List<Gift> gift1 = giftMapper.selectList(
                    new EntityWrapper<Gift>().eq("name", g.getName())
                            .orNew()
                            .eq("id", g.getId()));
            if (gift1.isEmpty()) {
                return APIResponse.error(CodeEnum.NUMBER_NOT_ENOUGH);
            } else {
                gift = gift1.get(0);
                gift.setStock(gift.getStock() - g.getOutNumber());
                gift.setOutput(gift.getOutput() + g.getOutNumber());
                gift.setAmount(gift.getStock() + gift.getOutput());
                Integer update = giftMapper.updateById(gift);
                if (update != 1) {
                    return APIResponse.error(CodeEnum.USE_ERROR);
                }
            }
        }
        return APIResponse.success();
    }

    /*
     * 导出Excel文件
     * */
    @Override
    public List<Gift> findAllGift2() {
        List<Gift> giftList = giftMapper.selectList(new EntityWrapper<>());

        return giftList;
    }
}
