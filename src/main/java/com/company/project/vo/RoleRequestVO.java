package com.company.project.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @desc The request DTO of role
 **/
@Data
@ApiModel(value = "The request DTO of role", description = "DTO")
public class RoleRequestVO {

    /**
     * role name
     */
    @NotEmpty(message = "The name can't be null or empty")
    private String name;
    
    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String username) {
        this.name = username;
    }

}
