package com.zjts.broadband.job.controller;

import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.controller.BaseController;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.project.ReqGiftAdd;
import com.zjts.broadband.common.model.req.job.project.ReqGiftQuery;
import com.zjts.broadband.common.model.req.job.project.ReqGiftUse;
import com.zjts.broadband.job.model.Gift;
import com.zjts.broadband.job.service.GiftService;
import com.zjts.broadband.util.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public APIResponse addGift(@RequestBody @Validated ReqGiftAdd reqGiftAdd, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        try {
            return giftService.add(reqGiftAdd);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.EXIT_ERROR);
        }
    }

    /*
     * 修改赠品
     * */
    @ApiOperation(value = "修改赠品接口")
    @Logger(name = "修改赠品")
    @RequestMapping(value = "gift/update", method = RequestMethod.POST)
    public APIResponse updateGift(@RequestBody @Validated ReqGiftQuery reqGiftQuery, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
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

    @ApiOperation(value = "任意条件查询（id，name，status）")
    @RequestMapping(value = "gift/findByName", method = RequestMethod.POST)
    public APIResponse findGift(@RequestBody ReqGiftQuery reqGiftQuery, HttpServletRequest request, HttpServletResponse response) {
        try {
            return giftService.findGift(reqGiftQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    @ApiOperation(value = "调用赠品")
    @RequestMapping(value = "gift/useGift", method = RequestMethod.POST)
    public APIResponse useGift(@RequestBody List<ReqGiftUse> list, HttpServletRequest request, HttpServletResponse response) {
        try {
            return giftService.useGift(list);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error(CodeEnum.ERROR);
        }
    }

    @ApiOperation(value = "生成Excel文件") //导出Excel时，实体类要指定列名
    @RequestMapping(value = "gift/excel", method = RequestMethod.POST)
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
