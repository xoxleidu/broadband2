package com.zjts.broadband.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zjts.broadband.job.model.Gift;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftMapper extends BaseMapper<Gift> {
    Integer updateGiftByid(Gift gift);

    Integer myInsert(Gift gift);

    Integer deleteGift(Gift gift);

    /*
     * 赠品调用入口
     * gId  ：  赠品id
     * number： 需要的数量
     * */
    Integer useGift(@Param("gId") Integer gId, @Param("numberr") Integer number);
}
