package com.zjts.broadband.job.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.controller.BaseController;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.orders.ReqOrderMiddleQuery;
import com.zjts.broadband.job.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(tags = "订单管理")
@RestController
@RequestMapping("order")
public class OrderMiddleController extends BaseController {


    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "根据用户ID查询产品类型接口")
    @RequestMapping(value = "OrderMiddle/selectByProductId", method = RequestMethod.POST)
    public APIResponse selectProductId(@RequestBody Integer id, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        try {
            return ordersService.findByProductId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    @ApiOperation(value = "根据用户ID和产品类型查询订单接口")
    @RequestMapping(value = "OrderMiddle/findSelectAll", method = RequestMethod.POST)
    public APIResponse findSelectAll(@RequestBody ReqOrderMiddleQuery reqOrderMiddleQuery, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        try {

            Page<Map> mapPage = new Page<>(reqOrderMiddleQuery.getCurrentPage(), reqOrderMiddleQuery.getPageSize());
            Page<Map> myItems = ordersService.findSelectAll(mapPage, reqOrderMiddleQuery);
            return APIResponse.success(myItems);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    @ApiOperation(value = "用户充值接口")
    @RequestMapping(value = "OrderMiddle/updateMoney", method = RequestMethod.POST)
    public APIResponse updateMoney(@RequestBody ReqOrderMiddleQuery reqOrderMiddleQuery, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        try {
            return APIResponse.success(ordersService.updateMoney(reqOrderMiddleQuery));
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    @ApiOperation(value = "订单确认接口")
    @RequestMapping(value = "OrderMiddle/OrderGeneration", method = RequestMethod.POST)
    public APIResponse OrderGeneration(@RequestBody ReqOrderMiddleQuery reqOrderMiddleQuery, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) return parameterVerification(bindingResult);
        try {
            return APIResponse.success(ordersService.selectByCustomerAll(reqOrderMiddleQuery));
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }
}
