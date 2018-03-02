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
@JsonIgnoreProperties(value = {"password"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name 用户名
     */
    private String name;

    /**
     * email 邮箱
     */
    private String email;

    /**
     * role 用户角色
     */
    private Role role;

    /**
     * createTime 用户的创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * password 用户的密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * lastPasswordResetDate 上次更新密码的时间
     */
    @Column(name = "last_password_reset_date")
    private  Date lastPasswordResetDate;

    /**
     * phone 用户注册的手机号
     */
    private String phone;
    
    /**
     * company 用户注册的公司
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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param phone
     */
    public void setCompany(String company) {
        this.company = company;
    }
    
    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return lastPasswordResetDate
     */
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    /**
     * @param lastPasswordResetDate
     */
    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
    
    /**
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}