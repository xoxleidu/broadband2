package com.zjts.broadband.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.job.model.OrderInsert;
import com.zjts.broadband.job.model.Orders;
import com.zjts.broadband.job.model.OrdersAll;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
    List<OrdersAll> selectByProductId(Integer id);

    List<Map> selectOrderAll(Page<Map> mapPage, OrdersAll orderQuery);

    int updateMoney(Orders orderQuery);
    int insertOrder(OrderInsert orderInsert);
}