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

public class CheckPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * startdate 用户名
     */
    @Column(name = "start_date")
    private Date startdate;

    /**
     * enddate 邮箱
     */
    @Column(name = "end_date")
    private Date enddate;

    /**
     * deviceid 用户角色
     */
    @Column(name = "device_id")
    private Long deviceid;

    /**
     * devicename 用户的创建时间
     */
    @Column(name = "device_name")
    private String devicename;


    /**
     * checktype 上次更新密码的时间
     */
    @Column(name = "check_type")
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
    @Column(name = "check_cycle")
    private  String checkcycle;
    
    /**
     * checkstate 上次更新密码的时间
     */
    @Column(name = "check_state")
    private  String checkstate;
    
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
     * @return checkstate
     */
    public String getCheckState() {
        return checkstate;
    }

    /**
     * @param checkstate
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