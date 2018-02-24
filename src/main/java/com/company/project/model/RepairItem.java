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

public class RepairItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * deviceid 用户名
     */
    @Column(name = "device_id")
    private Long deviceid;

    /**
     * devicename 邮箱
     */
    @Column(name = "device_name")
    private String devicename;

    /**
     * discription 用户角色
     */
    private String discription;

    /**
     * audiopath 用户的创建时间
     */
    @Column(name = "audio_path")
    private String audiopath;


    /**
     * picturepath 上次更新密码的时间
     */
    @Column(name = "picture_path")
    private  String picturepath;

    /**
     * checkowner 上次更新密码的时间
     */
    @Column(name = "check_owner")
    private  String checkowner;
    
    /**
     * checktime 上次更新密码的时间
     */
    @Column(name = "check_time")
    private  Date checktime;
    
    /**
     * acceptowner 上次更新密码的时间
     */
    @Column(name = "accept_owner")
    private  String acceptowner;
    
    /**
     * accepttime 上次更新密码的时间
     */
    @Column(name = "accept_time")
    private  Date accepttime;
    
    /**
     * repairstate 上次更新密码的时间
     */
    @Column(name = "repair_state")
    private  String repairstate;
    
    /**
     * repairowner 上次更新密码的时间
     */
    @Column(name = "repair_owner")
    private  String repairowner;
    
    /**
     * reparitime 上次更新密码的时间
     */
    @Column(name = "repair_time")
    private  Date repairtime;
    
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
     * @return deviceid
     */
    public Long getDeviceId() {
        return deviceid;
    }

    /**
     * @param id
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
     * @return discription
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * @param discription
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    /**
     * @return audiopath
     */
    public String getAudioPath() {
        return audiopath;
    }

    /**
     * @param audiopath
     */
    public void setAudioPath(String audiopath) {
        this.audiopath = audiopath;
    }
    
    /**
     * @return picturepath
     */
    public String getPicturePath() {
        return picturepath;
    }

    /**
     * @param picturepath
     */
    public void setPicturePath(String picturepath) {
        this.picturepath = picturepath;
    }
    
    
    /**
     * @return checkowner
     */
    public String getCheckOwner() {
        return checkowner;
    }

    /**
     * @param checkowner
     */
    public void setCheckOwner(String checkowner) {
        this.checkowner = checkowner;
    }
    
    /**
     * @return checktime
     */
    public Date getCheckTime() {
        return checktime;
    }

    /**
     * @param checktime
     */
    public void setCheckTime(Date checktime) {
        this.checktime = checktime;
    }
    
    /**
     * @return acceptowner
     */
    public String getAcceptOwner() {
        return acceptowner;
    }

    /**
     * @param acceptowner
     */
    public void setAcceptOwner(String acceptowner) {
        this.acceptowner = acceptowner;
    }
    
    /**
     * @return accepttime
     */
    public Date getAcceptTime() {
        return accepttime;
    }

    /**
     * @param checktime
     */
    public void setAcceptTime(Date accepttime) {
        this.accepttime = accepttime;
    }
    
    /**
     * @return repairstate
     */
    public String getRepairState() {
        return repairstate;
    }
    
    /**
     * @param repairstate
     */
    public void setRepairState(String repairstate) {
        this.repairstate = repairstate;
    }
    
    /**
     * @return repairowner
     */
    public String getRepairOwner() {
        return repairowner;
    }

    /**
     * @param repairowner
     */
    public void setRepairOwner(String repairowner) {
        this.repairowner = repairowner;
    }
    
    /**
     * @return repairtime
     */
    public Date getRepairTime() {
        return repairtime;
    }

    /**
     * @param repairtime
     */
    public void setRepairTime(Date repairtime) {
        this.repairtime = repairtime;
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