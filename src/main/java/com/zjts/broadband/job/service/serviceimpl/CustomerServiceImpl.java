package com.zjts.broadband.job.service.serviceimpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.customer.ReqCustomerAdd;
import com.zjts.broadband.common.model.req.job.customer.ReqCustomerDelete;
import com.zjts.broadband.common.model.req.job.customer.ReqCustomerQuery;
import com.zjts.broadband.common.model.req.job.customer.ReqCustomerUpdate;
import com.zjts.broadband.job.dao.CustomerMapper;
import com.zjts.broadband.job.model.CustomerMessage;
import com.zjts.broadband.job.service.CustomerService;
import com.zjts.broadband.system.model.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    /**
     * 添加客户
     * @param: 接收一个ReqCustomerAdd类型的对象
     * @return: 返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse add(ReqCustomerAdd reqCustomerAdd) throws Exception {
        CustomerMessage customerMessage = new CustomerMessage();
        BeanUtils.copyProperties(reqCustomerAdd, customerMessage);
        Integer insert = customerMapper.insert(customerMessage);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }
    /**
     * 修改客户信息
     * @param: 接收一个ReqCustomerUpdate类型的对象
     * @return:返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse update(ReqCustomerUpdate reqCustomerUpdate) throws Exception {
        CustomerMessage customerMessage = new CustomerMessage();
        BeanUtils.copyProperties(reqCustomerUpdate, customerMessage);
        Integer insert = customerMapper.updateById(customerMessage);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }
    /**
     * 逻辑删除客户信息
     * @param: 接收一个ReqCustomerDelete类型的对象
     * @return:返回到APIResponse包装类进行校验
     * @throws:Exception
     */
    @Override
    public APIResponse delete(ReqCustomerDelete reqCustomerDelete) throws Exception {
        CustomerMessage customerMessage = new CustomerMessage();
        customerMessage.setStatus(1);
        BeanUtils.copyProperties(reqCustomerDelete, customerMessage);
        int delete = customerMapper.updateById(customerMessage);
        if (delete != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }
    /**
     * 综合查询客户信息
     * @param: 接收一个ReqCustomerQuery类型的对象
     * @return: 返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse queryAll(ReqCustomerQuery reqCustomerQuery)throws Exception{
        //创建一个mybatisplus中的Page对象,把页数和数量写入
        Page<CustomerMessage>  cunstomerPage= new Page<CustomerMessage>(reqCustomerQuery.getCurrentPage(),reqCustomerQuery.getPageSize());
        //实现继承了BaseMapper中的方法,带入参数Page对象,创建一个mybatisplus中的实体包装器进行sql操作
        EntityWrapper  entityWrapper= new EntityWrapper();
        List<CustomerMessage> customerList = new ArrayList<CustomerMessage>();
       CustomerMessage  customerMessage = new CustomerMessage();
        BeanUtils.copyProperties(reqCustomerQuery, customerMessage);
        if(customerMessage.getStatus()==0||customerMessage.getStatus()==1) {
            entityWrapper.where("status={0}", customerMessage.getStatus());
            customerList = customerMapper.selectPage(cunstomerPage, entityWrapper);
            if (customerMessage.getCustomerName()!= null) {
                entityWrapper.like("customer_name",customerMessage.getCustomerName());
            } else if (customerMessage.getMobile() != null) {
                entityWrapper.orNew("mobile={0}", customerMessage.getMobile());
            } else if (customerMessage.getIdcard() != null) {
                entityWrapper.orNew("idcard={0}", customerMessage.getIdcard());
            }
        }
        if (customerList.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(cunstomerPage.setRecords(customerList));
    }
}
