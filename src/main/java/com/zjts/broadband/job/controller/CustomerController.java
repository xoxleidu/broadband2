package com.zjts.broadband.job.controller;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.controller.BaseController;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.job.model.CustomerMessage;
import com.zjts.broadband.job.model.QueryAllCustomer;

import com.zjts.broadband.job.model.TermQueryCustomer;
import io.swagger.annotations.Api;
import com.zjts.broadband.job.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "客户管理")
@RestController
@RequestMapping("customer")
public class CustomerController  extends BaseController  {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "客户添加接口")
    @RequestMapping(value = "customerMessage/add", method = RequestMethod.POST)
    public APIResponse addUser(@RequestBody @Validated CustomerMessage customer, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        try {
            return customerService.add(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    @ApiOperation(value = "客户修改接口")
    @RequestMapping(value = "customerMessage/update", method = RequestMethod.POST)
    public APIResponse update(@RequestBody @Validated CustomerMessage customer, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        try {
            return customerService.update(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }


    @ApiOperation(value = "客户删除接口")
    @RequestMapping(value = "customerMessage/delete", method = RequestMethod.POST)
    public APIResponse delete(@RequestBody @Validated int id, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        try {

            return customerService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    @ApiOperation(value = "客户查询所有")
    @RequestMapping(value = "customerMessage/queryAllCustomer",method = RequestMethod.POST)
    public APIResponse selectAll(@RequestBody @Validated QueryAllCustomer queryAllCustomer, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        return customerService.queryAll(queryAllCustomer);
    }


    @ApiOperation(value = "客户条件查询")
    @RequestMapping(value = "customerMessage/termQueryCustomer",method = RequestMethod.POST)
    public APIResponse selectAll(@RequestBody @Validated TermQueryCustomer termQueryCustomer, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        return customerService.termQueryCustomer(termQueryCustomer);
    }
}
