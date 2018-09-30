package com.zjts.broadband.job.service.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.common.constant.CodeEnum;
import com.zjts.broadband.common.model.APIResponse;
import com.zjts.broadband.common.model.req.job.product.ReqEquipmentModelAdd;
import com.zjts.broadband.common.model.req.job.product.ReqEquipmentModelQuery;
import com.zjts.broadband.job.dao.EquipmentModelMapper;
import com.zjts.broadband.job.model.Equipment;
import com.zjts.broadband.job.model.EquipmentModel;
import com.zjts.broadband.job.service.EquipmentModelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentModelServiceImpl implements EquipmentModelService {

    @Autowired
    private EquipmentModelMapper equipmentModelMapper;

    /*
     * 添加设备型号
     * */
    @Override
    public APIResponse add(ReqEquipmentModelAdd reqEquipmentModelAdd) {
        EquipmentModel equipmentModel=new EquipmentModel();
        BeanUtils.copyProperties(reqEquipmentModelAdd, equipmentModel);
        Integer insert = equipmentModelMapper.insert(equipmentModel);
        if (insert != 1) {
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
        return APIResponse.success();
    }

    /*
     * 修改单条记录
     * */
    @Override
    public APIResponse update(ReqEquipmentModelAdd reqEquipmentModelAdd) {
        EquipmentModel equipmentModel=new EquipmentModel();
        BeanUtils.copyProperties(reqEquipmentModelAdd, equipmentModel);
        if (!equipmentModel.getStatus().isEmpty()){
            Integer update = equipmentModelMapper.updateById(equipmentModel);
            if (update != 1) {
                return APIResponse.error(CodeEnum.DELETE_ERROR);
            }
            return APIResponse.success();
        }
        return APIResponse.error(CodeEnum.SAVE_ERROR);
    }

    /*
     * 查询设备
     * */
    @Override
    public APIResponse findEquipmentModel(ReqEquipmentModelQuery equipmentModel) {
        Page<EquipmentModel> page = new Page<EquipmentModel>(equipmentModel.getCurrentPage(), equipmentModel.getPageSize());
        EquipmentModel e=new EquipmentModel();
        BeanUtils.copyProperties(equipmentModel, e);
        List<EquipmentModel> myItems = equipmentModelMapper.findEquipmentModel(page, e);

        if (myItems.isEmpty()) {
            return APIResponse.error(CodeEnum.FIND_NULL_ERROR);
        }
        return APIResponse.success(page.setRecords(myItems));
    }


    /*
     * 导出Excel文件
     * */
    @Override
    public List<EquipmentModel> findForExcel() {
        List<EquipmentModel> em = equipmentModelMapper.selectList(new EntityWrapper<EquipmentModel>());
        return em;
    }

}