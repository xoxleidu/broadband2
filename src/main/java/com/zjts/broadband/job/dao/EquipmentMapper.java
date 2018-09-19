package com.zjts.broadband.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.broadband.job.model.Equipment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMapper extends BaseMapper<Equipment> {
    Integer myDeleteById(Equipment equipment);

    Equipment useEquipment(@Param("name") String name );

    List<Equipment> findEquipment(Page page, Equipment equipment);
}