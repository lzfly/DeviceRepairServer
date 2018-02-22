package com.company.project.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author jinhuaquan
 * @create 2018-01-11 下午10:02
 * @desc The request DTO of user
 **/
@Data
@ApiModel(value = "The request DTO of CheckPla", description = "DTO")
public class DeviceRequestVO {

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
    private  String ownername;
    
    /**
     * company 用户注册的手机号
     */
    private String company;
    
    


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
