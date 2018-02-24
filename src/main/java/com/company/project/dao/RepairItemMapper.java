package com.company.project.dao;

import com.company.project.model.RepairItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairItemMapper {

    /**
     * Save a new RepairItem
     * @param repairitem
     * @return
     */
    Long saveRepairItem(RepairItem repairitem);

    /**
     * Delete the RepairItem by id
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * Update the RepairItem's info
     * @param repairitem
     * @return
     */
    Long updateRepairItem(RepairItem device);

    /**
     * Find the RepairItem by id
     * @param id
     * @return
     */
    RepairItem findById(Long id);

    /**
     * List all of the RepairItem
     * @return
     */
    List<RepairItem> findAll();

    /**
     * Find RepairItem by company
     * @param company
     * @return
     */
    RepairItem findByCompany(String company);



}