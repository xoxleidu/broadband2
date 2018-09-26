package com.zjts.broadband.job.service.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.orders.ReqOrderMiddleQuery;
;
import com.zjts.broadband.job.dao.OrdersMapper;
import com.zjts.broadband.job.model.Orders;

import com.zjts.broadband.job.model.Orders_Expenses;
import com.zjts.broadband.job.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 根据用户ID查询产品类型
     *
     * @param: 接收一个 Integer类型的对象
     * @return: 返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse findByProductId(Integer id) throws Exception {
        List<Orders_Expenses> list = new ArrayList<Orders_Expenses>();
        try {
            list = ordersMapper.selectByProductId(id);
        } catch (Exception e) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(list);
    }

    /**
     * 根据用户ID和产品类型查询订单
     *
     * @param: 接收一个 Page<Map> 类型的对象 和 ReqOrderMiddleQuery类型的对象
     * @return: 返回到 Page<Map> 类型的的对象
     * @throws: Exception
     */
    @Override
    public Page<Map> findSelectAll(Page<Map> mapPage, ReqOrderMiddleQuery reqOrderMiddleQuery) throws Exception {
        Orders_Expenses orderQuery = new Orders_Expenses();
        BeanUtils.copyProperties(reqOrderMiddleQuery, orderQuery);
        mapPage.setRecords(ordersMapper.selectCustomerOrderAll(mapPage, orderQuery));
        return mapPage;
    }
    /**
     * 根据用户ID和订单ID进行用户充值
     *
     * @param:  ReqOrderMiddleQuery类型的对象
     * @return: 返回到 APIResponse 类型的的对象
     * @throws: Exception
     */
    @Override
    public APIResponse updateMoney(ReqOrderMiddleQuery reqOrderMiddleQuery) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(reqOrderMiddleQuery, orders);
        Integer insert = 1;//= orderMapper.updateMoney(order);
        EntityWrapper<Orders> entityWrapper = new EntityWrapper<Orders>();
        entityWrapper.setEntity(new Orders());
        entityWrapper.setSqlSelect("money").where("customer_id={0}", orders.getCustomerId()).and("id={0}", orders.getId());
        List<Orders> list = ordersMapper.selectList(entityWrapper);
        for (Orders or : list
                ) {
            orders.setMoney(or.getMoney() + orders.getMoney());
        }
        insert = ordersMapper.updateById(orders);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success(insert);
    }
    /**
     * 根据用户ID ，资费ID,套餐ID,设备ID，赠品ID进行详细查询
     *
     * @param:  ReqOrderMiddleQuery类型的对象
     * @return: 返回到 APIResponse 类型的的对象
     * @throws: Exception
     */
    @Override
    public APIResponse selectByCustomerAll(ReqOrderMiddleQuery reqOrderMiddleQuery) {
        Orders_Expenses orders_expenses = new Orders_Expenses();
        BeanUtils.copyProperties(reqOrderMiddleQuery, orders_expenses);
        return APIResponse.success(ordersMapper.selectByOrderAll(orders_expenses)) ;
    }
}
