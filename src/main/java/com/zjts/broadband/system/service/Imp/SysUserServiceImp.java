package com.zjts.broadband.system.service.Imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.system.ReqSysUserAdd;
import com.zjts.broadband.system.dao.SysUserMapper;
import com.zjts.broadband.system.model.SysUser;
import com.zjts.broadband.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImp implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public APIResponse add(ReqSysUserAdd sysUser) {
        SysUser sysUser1 = new SysUser();
        BeanUtils.copyProperties(sysUser, sysUser1);
        Integer insert = sysUserMapper.insert(sysUser1);
        if (insert != 1){
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }
}
