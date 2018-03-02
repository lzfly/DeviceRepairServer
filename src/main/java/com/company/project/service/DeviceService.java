package com.company.project.service;

import com.company.project.vo.DeviceRequestVO;
import com.company.project.model.Device;
import com.github.pagehelper.PageInfo;

/**
 *
 * @author CodeGenerator
 * @date 2017/10/15
 *
 * User的service层接口
 */
public interface DeviceService {

    /**
     * 注册一个新用户
     * @param userRegisterVO
     * @return
     */
    Long saveDevice(DeviceRequestVO requestDTO);

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
    Long updateDevice(Long id, DeviceRequestVO requestDTO);

    /**
     * 根据id查询特定用户
     * @param id
     * @return
     */
    Device findById(Long id);

    /**
     * 查询所有的用户
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Device> findAll(Integer pageNo, Integer pageSize);

    /**
     * 根据手机号查询出用户
     * @param company
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Device> findAllByCompany(String company, Integer pageNo, Integer pageSize);



}
