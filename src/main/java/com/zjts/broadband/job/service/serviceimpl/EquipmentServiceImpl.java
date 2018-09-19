package com.zjts.broadband.job.service.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.project.ReqEquipmentAdd;
import com.zjts.broadband.common.model.req.job.project.ReqEquipmentQuery;
import com.zjts.broadband.common.model.req.job.project.ReqEquipmentUse;
import com.zjts.broadband.job.dao.EquipmentMapper;
import com.zjts.broadband.job.model.Equipment;
import com.zjts.broadband.job.service.EquipmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /*
     * 添加设备
     * */
    @Override
    public APIResponse add(ReqEquipmentAdd reqEquipmentAdd) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(reqEquipmentAdd, equipment);
        int current = (int) (System.currentTimeMillis() / 1000);
        equipment.setAddTime(current);
        equipment.setStatus("0");
        Integer insert = equipmentMapper.insert(equipment);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /*
     * 根据id修改状态,id status
     * */
    @Override
    public APIResponse update(ReqEquipmentQuery reqEquipmentQuery) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(reqEquipmentQuery, equipment);
        if (equipment.getStatus().equals("2")) {
            int current = (int) (System.currentTimeMillis() / 1000);
            equipment.setOutTime(current);
        }

        Integer delete = equipmentMapper.myDeleteById(equipment);
        if (delete != 1) {
            return APIResponse.error(CodeEnum.DELETE_ERROR);
        }

        return APIResponse.success();
    }

    /*
     * 设备回收
     * */
    @Override
    public APIResponse recovery(ReqEquipmentQuery reqEquipmentAdd) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(reqEquipmentAdd, equipment);
        equipment.setOutTime(0);
        equipment.setStatus("0");
        Integer update = equipmentMapper.updateById(equipment);
        if (update != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }


    /*
     * 查询全部设备
     * */
    @Override
    public APIResponse findAllEquipment(ReqEquipmentQuery reqEquipmentQuery) {
        Page<Equipment> page = new Page<Equipment>(reqEquipmentQuery.getCurrentPage(), reqEquipmentQuery.getPageSize());
        List<Equipment> myItems = equipmentMapper.selectPage(page,
                new EntityWrapper<Equipment>()
        );
        if (myItems.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(myItems));
    }

    /*
     * 查询设备
     * */
    @Override
    public APIResponse findEquipment(ReqEquipmentQuery reqEquipmentQuery) {
        Page<Equipment> page = new Page<Equipment>(reqEquipmentQuery.getCurrentPage(), reqEquipmentQuery.getPageSize());
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(reqEquipmentQuery, equipment);
        List<Equipment> myItems = equipmentMapper.findEquipment(page, equipment);

        if (myItems.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(myItems));
    }

    /*
     * 导出Excel文件
     * */
    @Override
    public List<Equipment> findAllGift2() {
        List<Equipment> myItems = equipmentMapper.selectList(new EntityWrapper<Equipment>());
        return myItems;
    }

    /*
     * 设备调用
     * */
    @Override
    public APIResponse useEquipment(List<ReqEquipmentUse> list) {
        List<Equipment> resultList = new ArrayList<>();
        Equipment equipment = new Equipment();
        for (ReqEquipmentUse r : list) {
            for (int i = 0; i < r.getNumber(); i++) {
                equipment = equipmentMapper.useEquipment(r.getName());
                if (equipment != null) {
                    equipment.setStatus("1");
                    equipmentMapper.updateById(equipment);
                    resultList.add(equipment);
                }else {
                    return APIResponse.error(CodeEnum.NUMBER_NOT_ENOUGH);
                }
            }
        }
        return APIResponse.success(resultList);
    }
}
