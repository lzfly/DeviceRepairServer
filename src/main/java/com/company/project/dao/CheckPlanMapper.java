package com.company.project.dao;

import com.company.project.model.CheckPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckPlanMapper {

    /**
     * Save a new CheckPlan
     * @param checkplan
     * @return
     */
    Long saveCheckPlan(CheckPlan checkplan);

    /**
     * Delete the CheckPlan by id
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * Update the CheckPlan's info
     * @param checkplan
     * @return
     */
    Long updateCheckPlan(CheckPlan checkplan);

    /**
     * Find the CheckPlan by id
     * @param id
     * @return
     */
    CheckPlan findById(Long id);

    /**
     * List all of the CheckPlan
     * @return
     */
    List<CheckPlan> findAll();

    /**
     * Find CheckPlan by company
     * @param company
     * @return
     */
    List<CheckPlan> findByCompany(String company);



}