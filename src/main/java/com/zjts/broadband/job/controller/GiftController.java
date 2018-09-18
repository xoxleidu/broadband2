package com.zjts.broadband.job.controller;

import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.controller.BaseController;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.project.ReqGiftAdd;
import com.zjts.broadband.common.model.req.job.project.ReqGiftQuery;
import com.zjts.broadband.job.model.Gift;
import com.zjts.broadband.job.service.GiftService;
import com.zjts.broadband.util.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Api(tags = "赠品管理")
@RestController
@RequestMapping("project")
public class GiftController extends BaseController {
    @Autowired
    private GiftService giftService;

    /*
     * 新建赠品分类； 接收name和stock（数量）
     * */
    @ApiOperation(value = "新建赠品分类接口")
    @RequestMapping(value = "gift/add", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse addGift(@RequestBody ReqGiftAdd reqGiftAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            return giftService.add(reqGiftAdd);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR, "新增分类失败");
        }
    }

    /*
     * 修改赠品数量
     * */
    @ApiOperation(value = "修改赠品数量接口（id，stock）")
    @Logger(name = "修改赠品数量")
    @RequestMapping(value = "gift/update", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse updateGift(@RequestBody ReqGiftQuery reqGiftQuery, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            return giftService.update(reqGiftQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    /*
     * 修改赠品状态，需要传状态值status=？
     * */
    @ApiOperation(value = "作废/启用赠品接口（id，status(1/0)）")
    @RequestMapping(value = "gift/delete", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse updateGift(@RequestBody ReqGiftQuery reqGiftQuery, HttpServletRequest request, HttpServletResponse response) {
        try {
            return giftService.delete(reqGiftQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    /*
     * 查询全部赠品
     * */
    @ApiOperation(value = "查询全部赠品（current，size）")
    @RequestMapping(value = "gift/findAllGift", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse findAllGift(@RequestBody ReqGiftQuery reqGiftQuery, HttpServletRequest request, HttpServletResponse response) {
        return giftService.findAllGift(reqGiftQuery);
    }

    /*
     * 按名称查询
     * */
    @ApiOperation(value = "按名称查询（name,current，size）")
    @RequestMapping(value = "gift/findByName", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse findByName(@RequestBody ReqGiftQuery reqGiftQuery, HttpServletRequest request, HttpServletResponse response) {
        return giftService.findByName(reqGiftQuery);
    }

    /*
     * 按状态查询
     * */
    @ApiOperation(value = "按状态查询（status,current，size）")
    @RequestMapping(value = "gift/findByStatus", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse findByStatus(@RequestBody ReqGiftQuery reqGiftQuery, HttpServletRequest request, HttpServletResponse response) {
        return giftService.findByStatus(reqGiftQuery);
    }
    /*
     * 按id查询
     * */
    @ApiOperation(value = "按id查询（id,current，size）")
    @RequestMapping(value = "gift/findById", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse findById(@RequestBody ReqGiftQuery reqGiftQuery, HttpServletRequest request, HttpServletResponse response) {
        return giftService.findById(reqGiftQuery);
    }

    @ApiOperation(value = "生成Excel文件") //导出Excel时，实体类要指定列名
    @RequestMapping(value = "gift/excel", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse deptExcel(@RequestBody Gift gift, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Gift> list = this.giftService.findAllGift2();
            return FileUtils.createExcelByPOIKit("赠品表", list, Gift.class);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR, "导出Excel失败，请联系网站管理员！");
        }
    }

}