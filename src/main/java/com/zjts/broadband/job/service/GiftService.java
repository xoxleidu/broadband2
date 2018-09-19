package com.zjts.broadband.job.service;

import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.project.ReqGiftAdd;
import com.zjts.broadband.common.model.req.job.project.ReqGiftQuery;
import com.zjts.broadband.common.model.req.job.project.ReqGiftUse;
import com.zjts.broadband.job.model.Gift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiftService {
    APIResponse update(ReqGiftQuery reqQuery);

    APIResponse add(ReqGiftAdd reqAdd);

    APIResponse findAllGift(ReqGiftQuery reqGiftQuery);

    APIResponse delete(ReqGiftQuery reqGiftQuery);
    /*
     * 根据状态查询
     * */
    APIResponse findGift(ReqGiftQuery reqGiftQuery);

    List<Gift> findAllGift2();

    APIResponse useGift(List<ReqGiftUse> list);
}
