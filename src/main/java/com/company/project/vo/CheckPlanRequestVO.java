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
public class CheckPlanRequestVO {

    /**
     * startdate 用户名
     */
    private Date startdate;

    /**
     * enddate 邮箱
     */
    private Date enddate;

    /**
     * deviceid 用户角色
     */
    private Long deviceid;

    /**
     * devicename 用户的创建时间
     */
    private String devicename;


    /**
     * checktype 上次更新密码的时间
     */
    private  String checktype;

    /**
     * ownername 上次更新密码的时间
     */
    private  String ownername;
    
    /**
     * project 上次更新密码的时间
     */
    private  String project;
    
    /**
     * checktype 上次更新密码的时间
     */
    private  String checkcycle;
    
    /**
     * checktype 上次更新密码的时间
     */
    private  String checkstate;
    
    /**
     * company 用户注册的手机号
     */
    private String company;
    
    

    /**
     * @return startdate
     */
    public Date getStartDate() {
        return startdate;
    }

    /**
     * @param name
     */
    public void setStartDate(Date startdate) {
        this.startdate = startdate;
    }
    
    /**
     * @return enddate
     */
    public Date getEndDate() {
        return enddate;
    }

    /**
     * @param name
     */
    public void setEndDate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * @return deviceid
     */
    public Long getDeviceId() {
        return deviceid;
    }

    /**
     * @param deviceid
     */
    public void setDeviceId(Long deviceid) {
        this.deviceid = deviceid;
    }
    
    /**
     * @return devicename
     */
    public String getDeviceName() {
        return devicename;
    }

    /**
     * @param devicename
     */
    public void setDeviceName(String devicename) {
        this.devicename = devicename;
    }
    
    /**
     * @return checktype
     */
    public String getCheckType() {
        return checktype;
    }

    /**
     * @param phone
     */
    public void setCheckType(String checktype) {
        this.checktype = checktype;
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
     * @return project
     */
    public String getProject() {
        return project;
    }

    /**
     * @param project
     */
    public void setProject(String project) {
        this.project = project;
    }
    
    
    /**
     * @return checkcycle
     */
    public String getCheckCycle() {
        return checkcycle;
    }

    /**
     * @param checkcycle
     */
    public void setCheckCycle(String checkcycle) {
        this.checkcycle = checkcycle;
    }
    
    /**
     * @return chcekstate
     */
    public String getCheckState() {
        return checkstate;
    }

    /**
     * @param chcekstate
     */
    public void setCheckState(String checkstate) {
        this.checkstate = checkstate;
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
