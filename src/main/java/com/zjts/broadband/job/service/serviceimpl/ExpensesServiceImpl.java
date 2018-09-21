package com.zjts.broadband.job.service.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.product.ReqExpensesAdd;
import com.zjts.broadband.common.model.req.job.product.ReqExpensesQuery;
import com.zjts.broadband.job.dao.ExpensesMapper;
import com.zjts.broadband.job.model.Expenses;
import com.zjts.broadband.job.service.ExpensesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesMapper expensesMapper;

    @Override
    public APIResponse add(ReqExpensesAdd reqExpensesAdd) {
        Expenses expenses=new Expenses();
        BeanUtils.copyProperties(reqExpensesAdd, expenses);
        expenses.setStatus("0");
        Integer insert = expensesMapper.insert(expenses);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /*
    * 修改资费
    * */
    @Override
    public APIResponse update(ReqExpensesAdd reqExpensesAdd) {
        Expenses expenses=new Expenses();
        BeanUtils.copyProperties(reqExpensesAdd, expenses);
        Integer update = expensesMapper.updateById(expenses);
        if (update != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /*
    * 查询资费
    * */
    @Override
    public APIResponse findExpenses(ReqExpensesQuery reqExpensesQuery) {
        Page<Expenses> page = new Page<Expenses>(reqExpensesQuery.getCurrentPage(), reqExpensesQuery.getPageSize());
        Expenses expenses=new Expenses();
        BeanUtils.copyProperties(reqExpensesQuery, expenses);

        EntityWrapper<Expenses> ew = new EntityWrapper<Expenses>();
        ew.where("1=1");
        if (expenses.getId() != null && expenses.getId() != 0) {
            ew.and().eq("id", expenses.getId());
        }
        if (expenses.getName() != null && expenses.getName() != "") {
            ew.and().like("name", expenses.getName());
        }
        if (expenses.getType() != null && expenses.getType() != "") {
            ew.and().eq("type", expenses.getType());
        }
        if (expenses.getIpId() != null) {
            ew.and().eq("ip_id", expenses.getIpId());
        }
        if (expenses.getBandwidthId() != null) {
            ew.and().eq("bandwidth_id", expenses.getBandwidthId());
        }
        if (expenses.getPrice() != null) {
            ew.and().eq("price", expenses.getPrice());
        }
        if (expenses.getCycle() != null) {
            ew.and().eq("cycle", expenses.getCycle());
        }
        if (expenses.getStatus() != null&& expenses.getStatus() != "") {
            ew.and().eq("status", expenses.getStatus());
        }
        List<Expenses> list = expensesMapper.selectPage(page, ew);
        if (list.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(list));
    }






}
