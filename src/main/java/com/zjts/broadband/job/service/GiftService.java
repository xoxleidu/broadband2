package com.zjts.broadband.job.service;

import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.product.ReqGiftAdd;
import com.zjts.broadband.common.model.req.job.product.ReqGiftQuery;
import com.zjts.broadband.common.model.req.job.product.ReqGiftUse;
import com.zjts.broadband.job.model.Gift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiftService {
    APIResponse update(ReqGiftQuery reqGiftQuery);

    APIResponse add(ReqGiftAdd reqAdd);

    APIResponse findGift(ReqGiftQuery reqGiftQuery);

    List<Gift> findAllGift2();

    APIResponse useGift(List<ReqGiftUse> list);
}
