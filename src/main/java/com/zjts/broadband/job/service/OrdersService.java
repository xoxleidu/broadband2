package com.zjts.broadband.job.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.orders.ReqOrderAdd;
import com.zjts.broadband.common.model.req.job.orders.ReqOrderMiddleQuery;

import java.util.Map;

public interface OrdersService {
    APIResponse findByProductId(Integer id) throws Exception;
    Page<Map> findSelectAll(Page<Map> mapPage, ReqOrderMiddleQuery reqOrderMiddleQuer) throws Exception;
    APIResponse updateMoney(ReqOrderMiddleQuery reqOrderMiddleQuery) throws Exception;
    APIResponse orderInsert(ReqOrderAdd reqOrderAdd) throws Exception;
}
