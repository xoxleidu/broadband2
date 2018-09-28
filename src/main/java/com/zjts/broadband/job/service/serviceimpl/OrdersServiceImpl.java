package com.zjts.broadband.job.service.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.orders.ReqOrderAdd;
import com.zjts.broadband.common.model.req.job.orders.ReqOrderMiddleQuery;
;
import com.zjts.broadband.job.dao.OrdersMapper;
import com.zjts.broadband.job.model.Equipment;
import com.zjts.broadband.job.model.OrderInsert;
import com.zjts.broadband.job.model.Orders;

import com.zjts.broadband.job.model.OrdersAll;
import com.zjts.broadband.job.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<OrdersAll> list = new ArrayList<OrdersAll>();
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
        OrdersAll ordersAll = new OrdersAll();
        BeanUtils.copyProperties(reqOrderMiddleQuery, ordersAll);
        mapPage.setRecords(ordersMapper.selectOrderAll(mapPage, ordersAll));
        return mapPage;
    }

    /**
     * 根据用户ID和订单ID进行用户充值
     *
     * @param: ReqOrderMiddleQuery类型的对象
     * @return: 返回到 APIResponse 类型的的对象
     * @throws: Exception
     */
    @Override
    public APIResponse updateMoney(ReqOrderMiddleQuery reqOrderMiddleQuery) throws Exception{
        Orders orders = new Orders();
        BeanUtils.copyProperties(reqOrderMiddleQuery, orders);
        Integer insert = 1;//= orderMapper.updateMoney(order);
        EntityWrapper<Orders> entityWrapper = new EntityWrapper<Orders>();
        entityWrapper.setEntity(new Orders());
        orders.setId(reqOrderMiddleQuery.getOrderId());
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
     * 根据用户ID和产品ID产生订单
     *
     * @param: ReqOrderAdd类型的对象
     * @return: 返回到 APIResponse 类型的的对象
     * @throws: Exception
     */
    @Override
    public APIResponse orderInsert(ReqOrderAdd reqOrderAdd)  throws Exception{
        OrderInsert orderInsert = new OrderInsert();
        Orders orders =new Orders();
        List list=new ArrayList<>();
        BeanUtils.copyProperties(reqOrderAdd, orderInsert);
        BeanUtils.copyProperties(reqOrderAdd, orders);
        int a[] = new int[10];
        //订单号
        orders.setOrderNumber(GetRandomString(20));
        //订单创建时间
        orders.setCreateTime( Math.toIntExact(new Date().getTime() / 1000));
         //  int relust= ordersMapper.insertOrder(orderInsert);
        for (Object o: orderInsert.getEquipmentId()
             ) {

        }
        for (Object orderInsert1: orderInsert.getGiftId()
             ) {
            list.add(orderInsert1);
        }
        for (Object l:list
             ) {
            System.out.print(l);
        }
         //  int  insert =ordersMapper.insert(orders);
        //if (insert != 1 && relust!=1) {
        //    return APIResponse.error(CodeEnum.SAVE_ERROR);
    //    }
        return APIResponse.success();
    }

/**
 *
 * 生成随机的订单号
 * */
    public static String GetRandomString(int Len) {

        String[] baseString={"0","1","2","3",
                "4","5","6","7","8","9",
                "a","b","c","d","e",
                "f","g","h","i","j",
                "k","l","m","n","o",
                "p","q","r","s","t",
                "u","v","w","x","y",
                "z","A","B","C","D",
                "E","F","G","H","I",
                "J","K","L","M","N",
                "O","P","Q","R","S",
                "T","U","V","W","X","Y","Z"};
        Random random = new Random();
        int length=baseString.length;
        String randomString="";
        for(int i=0;i<length;i++){
            randomString+=baseString[random.nextInt(length)];
        }
        random = new Random(System.currentTimeMillis());
        String resultStr="";
        for (int i = 0; i < Len; i++) {
            resultStr += randomString.charAt(random.nextInt(randomString.length()-1));
        }
        return resultStr;
    }

}
