package com.company.project.dao;

import com.company.project.model.Device;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper {

    /**
     * Save a new Device
     * @param device
     * @return
     */
    Long saveDevice(Device device);

    /**
     * Delete the Device by id
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * Update the Device's info
     * @param device
     * @return
     */
    Long updateDevice(Device device);

    /**
     * Find the Device by id
     * @param id
     * @return
     */
    Device findById(Long id);

    /**
     * List all of the Device
     * @return
     */
    List<Device> findAll();

    /**
     * Find Devices by company
     * @param company
     * @return
     */
    List<Device> findByCompany(String company);



}