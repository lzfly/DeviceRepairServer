package com.company.project.service;

import com.company.project.vo.RepairItemRequestVO;
import com.company.project.model.RepairItem;
import com.github.pagehelper.PageInfo;

/**
 *
 * @author CodeGenerator
 * @date 2017/10/15
 *
 * User的service层接口
 */
public interface RepairItemService {

    /**
     * 注册一个新用户
     * @param userRegisterVO
     * @return
     */
    Long saveRepairItem(RepairItemRequestVO requestDTO);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * 更新用户信息
     * @param id
     * @param requestDTO
     * @return
     */
    Long updateRepairItem(Long id, RepairItemRequestVO requestDTO);

    /**
     * 根据id查询特定用户
     * @param id
     * @return
     */
    RepairItem findById(Long id);

    /**
     * 查询所有的用户
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<RepairItem> findAll(Integer pageNo, Integer pageSize);

    /**
     * 根据手机号查询出用户
     * @param company
     * @return
     */
    PageInfo<RepairItem> findAllByCompany(String company, Integer pageNo, Integer pageSize);



}
