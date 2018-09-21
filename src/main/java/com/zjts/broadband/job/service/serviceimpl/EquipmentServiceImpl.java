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
     * 修改单条记录
     * */
    @Override
    public APIResponse update(ReqEquipmentAdd reqEquipmentAdd) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(reqEquipmentAdd, equipment);
        if (equipment.getStatus().equals("2")) {
            int current = (int) (System.currentTimeMillis() / 1000);
            equipment.setOutTime(current);
        }
        if (equipment.getStatus().equals("0")){
            equipment.setOutTime(0);
        }
        Integer delete = equipmentMapper.updateById(equipment) ;
        if (delete != 1) {
            return APIResponse.error(CodeEnum.DELETE_ERROR);
        }

        return APIResponse.success();
    }

    /*
     * 查询设备
     * */
    @Override
    public APIResponse findEquipment(ReqEquipmentQuery reqEquipmentQuery) {
        Page<Equipment> page = new Page<Equipment>(reqEquipmentQuery.getCurrentPage(), reqEquipmentQuery.getPageSize());
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(reqEquipmentQuery, equipment);

        EntityWrapper<Equipment> ew = new EntityWrapper<Equipment>();
        ew.where("1=1");//完善where条件语法
        if (equipment.getId() != null && equipment.getId() != 0) {
            ew.and().eq("id", equipment.getId());
        }
        if (equipment.getName() != null && equipment.getName() !="") {
            ew.and().like("name", equipment.getName());
        }
        if (equipment.getPrice() != null) {
            ew.and().eq("price", equipment.getPrice());
        }
        if(equipment.getCode()!= null){
            ew.and().eq("code",equipment.getCode());
        }
        if (equipment.getStatus() != null) {
            ew.and().eq("status", equipment.getStatus());
        }

        List<Equipment> myItems = equipmentMapper.selectPage(page,ew);
        if (myItems.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(myItems));
    }

    /*
     * 设备调用
     * */
    @Override
    public APIResponse useEquipment(List<ReqEquipmentUse> list) {
        List<Equipment> resultList = new ArrayList<>();
        List<Equipment> list1=new ArrayList<>();

        for (ReqEquipmentUse r : list) {
            for (int i = 0; i < r.getNumber(); i++) {
                list1 = equipmentMapper.selectList(
                        new EntityWrapper<Equipment>().eq("name", r.getName())
                                .eq("status", "0")
                                .last("limit 1"));
                if (list1.isEmpty()) {
                    return APIResponse.error(CodeEnum.NUMBER_NOT_ENOUGH);
                } else {
                    list1.get(0).setStatus("1");
                    equipmentMapper.updateById(list1.get(0));
                    resultList.add(list1.get(0));
                    list1 = null;
                }
            }
        }
        return APIResponse.success(resultList);
    }

    /*
     * 导出Excel文件
     * */
    @Override
    public List<Equipment> findAllGift2() {
        List<Equipment> myItems = equipmentMapper.selectList(new EntityWrapper<Equipment>());
        return myItems;
    }

}
