package com.zjts.broadband.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.job.model.Orders;
import com.zjts.broadband.job.model.Orders_Expenses;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
    Orders_Expenses selectByPrimaryKey(Integer id);

    List<Orders_Expenses> selectByProductId(Integer id);

    List<Map> selectCustomerOrderAll(Page<Map> mapPage, Orders_Expenses orderQuery);

    int updateMoney(Orders orderQuery);
    List<Orders_Expenses>  selectByOrderAll(Orders_Expenses orderQuery);
}