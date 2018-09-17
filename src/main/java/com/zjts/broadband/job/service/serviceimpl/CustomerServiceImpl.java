package com.zjts.broadband.job.service.serviceimpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.job.dao.CustomerMapper;
import com.zjts.broadband.job.model.CustomerMessage;
import com.zjts.broadband.job.model.QueryAllCustomer;
import com.zjts.broadband.job.model.TermQueryCustomer;
import com.zjts.broadband.job.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 添加客户
     * @param: 接收一个CustomerMessage类型的对象
     * @return: 返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse add(CustomerMessage customer) throws Exception {

        Integer insert = customerMapper.insert(customer);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /**
     * 修改客户信息
     * @param: 接收一个CustomerMessage类型的对象
     * @return:返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse update(CustomerMessage customer) throws Exception {
        Integer insert = customerMapper.updateById(customer);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /**
     * 逻辑删除客户信息
     * @param: 接收一个Customer类型的对象
     * @return:返回到APIResponse包装类进行校验
     * @throws:Exception
     */
    @Override
    public APIResponse delete(int id) throws Exception {
        int delete = customerMapper.delete(id);
        if (delete != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }


    /**
     *查询客户所有信息
     * @param: 接收一个QueryAllCustomer类型的对象
     * @return:返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse queryAll(QueryAllCustomer queryAllCustomer)throws Exception{
        //创建一个mybatisplus中的Page对象,把页数和数量写入
        Page<CustomerMessage>  cunstomerPage= new Page<CustomerMessage>(queryAllCustomer.getCurrentPage(),queryAllCustomer.getPageSize());
        //实现继承了BaseMapper中的方法,带入参数Page对象,创建一个mybatisplus中的实体包装器进行sql操作
        List<CustomerMessage>  customerList=  customerMapper.selectPage(cunstomerPage, new EntityWrapper<CustomerMessage>().eq("status",queryAllCustomer.getStatus()));
        if (customerList.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(cunstomerPage.setRecords(customerList));
    }

    /**
     * 条件查询客户信息
     * @param: 接收一个TermQueryCustomer类型的对象
     * @return: 返回到APIResponse包装类进行校验
     * @throws: Exception
     */
    @Override
    public APIResponse termQueryCustomer(TermQueryCustomer termQueryCustomer)throws Exception{
        //创建一个mybatisplus中的Page对象,把页数和数量写入
        Page<CustomerMessage>  cunstomerPage= new Page<CustomerMessage>(termQueryCustomer.getCurrentPage(),termQueryCustomer.getPageSize());
        //实现继承了BaseMapper中的方法,带入参数Page对象,创建一个mybatisplus中的实体包装器进行sql操作
        List<CustomerMessage>  customerList=  customerMapper.selectPage(cunstomerPage, new EntityWrapper<CustomerMessage>() .where("status={0}",termQueryCustomer.getStatus()).like("customer_name",termQueryCustomer.getCustomerName()));

        if (customerList.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(cunstomerPage.setRecords(customerList));
    }
}
