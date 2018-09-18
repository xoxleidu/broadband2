package com.zjts.broadband.job.service;

import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.project.ReqGiftAdd;
import com.zjts.broadband.common.model.req.job.project.ReqGiftQuery;
import com.zjts.broadband.job.model.Gift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiftService {
    APIResponse update(ReqGiftQuery reqQuery);

    APIResponse add(ReqGiftAdd reqAdd);

    APIResponse findAllGift(ReqGiftQuery reqGiftQuery);

    APIResponse delete(ReqGiftQuery reqGiftQuery);

    List<Gift> findAllGift2();

    APIResponse findByName(ReqGiftQuery reqGiftQuery);

    APIResponse findByStatus(ReqGiftQuery reqGiftQuery);

    APIResponse findById(ReqGiftQuery reqGiftQuery);
}
