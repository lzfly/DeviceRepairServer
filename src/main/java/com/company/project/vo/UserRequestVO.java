package com.company.project.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author jinhuaquan
 * @create 2018-01-11 下午10:02
 * @desc The request DTO of user
 **/
@Data
@ApiModel(value = "The request DTO of user", description = "DTO")
public class UserRequestVO {

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
    private String roleName;

    /**
     * phone 用户注册的手机号
     */
    private String phone;
    
    private String company;
    
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
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param password
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * @return company
     */
    public String getCompany() {
        return phone;
    }

    /**
     * @param company
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
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
