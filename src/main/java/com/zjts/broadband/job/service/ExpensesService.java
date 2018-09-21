package com.zjts.broadband.job.service;

import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.project.ReqExpensesAdd;
import com.zjts.broadband.common.model.req.job.project.ReqExpensesQuery;
import org.springframework.stereotype.Service;

@Service
public interface ExpensesService {

    APIResponse add(ReqExpensesAdd reqExpensesAdd);

    APIResponse update(ReqExpensesAdd reqExpensesAdd);

    APIResponse findExpenses(ReqExpensesQuery reqExpensesQuery);
}
