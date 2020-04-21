package com.wlp.swaggerdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户名")
    private String username ;
    @ApiModelProperty("用户年龄")
    private Integer age ;

    /**
     *
     * 没有get/set方法时，swagger不会显示该属性
     */



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
