package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * sn 用户名
     */
    private String sn;

    /**
     * name 邮箱
     */
    private String name;

    /**
     * region 用户角色
     */
    private String region;

    /**
     * type 用户的创建时间
     */
    private String type;


    /**
     * factory 上次更新密码的时间
     */
    private  String factory;

    /**
     * date 上次更新密码的时间
     */
    private  Date date;
    
    /**
     * ownername 上次更新密码的时间
     */
    @Column(name = "owner_name")
    private  String ownername;
    
    /**
     * company 用户注册的手机号
     */
    private String company;
    
    
    
    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return sn
     */
    public String getSN() {
        return sn;
    }

    /**
     * @param sn
     */
    public void setSN(String sn) {
        this.sn = sn;
    }
    
    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }
    
    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return factory
     */
    public String getFactory() {
        return factory;
    }

    /**
     * @param factory
     */
    public void setFactory(String factory) {
        this.factory = factory;
    }
    
    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
    /**
     * @return ownername
     */
    public String getOwnerName() {
        return ownername;
    }

    /**
     * @param email
     */
    public void setOwnerName(String ownername) {
        this.ownername = ownername;
    }
    
    
    /**
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }
}