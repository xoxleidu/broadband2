package com.zjts.broadband.job.service;


import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.customer.ReqCustomerAdd;
import com.zjts.broadband.common.model.req.job.customer.ReqCustomerQuery;
import com.zjts.broadband.common.model.req.job.customer.ReqCustomerUpdate;
import com.zjts.broadband.job.model.CustomerMessage;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    APIResponse add(ReqCustomerAdd reqCustomerAdd) throws Exception;
    APIResponse update(ReqCustomerUpdate reqCustomerUpdate)throws Exception;
    APIResponse delete(int id)throws Exception;
    APIResponse queryAll(ReqCustomerQuery reqCustomerQuery)throws Exception;
}
