package com.zjts.broadband.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zjts.broadband.job.model.CustomerMessage;
import org.springframework.stereotype.Service;

@Service
public interface CustomerMapper extends BaseMapper<CustomerMessage> {
    CustomerMessage selectByPrimaryKey(Integer id);
    int delete(Integer id);



}