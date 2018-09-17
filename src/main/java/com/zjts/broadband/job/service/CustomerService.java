package com.zjts.broadband.job.service;


import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.job.model.CustomerMessage;
import com.zjts.broadband.job.model.QueryAllCustomer;

import com.zjts.broadband.job.model.TermQueryCustomer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    APIResponse add(CustomerMessage customer) throws Exception;
    APIResponse update(CustomerMessage customer)throws Exception;
    APIResponse delete(int id)throws Exception;
    APIResponse queryAll(QueryAllCustomer queryAllCustomer)throws Exception;
    APIResponse termQueryCustomer(TermQueryCustomer termQueryCustomer)throws Exception;
}
