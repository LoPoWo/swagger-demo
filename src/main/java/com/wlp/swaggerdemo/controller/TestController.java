package com.wlp.swaggerdemo.controller;

import com.wlp.swaggerdemo.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @ApiOperation("返回空user")
    @PostMapping("/user")
    public User user(){
        return new User();
    }
    @ApiOperation("测试方法2")
    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }

    //rest API 里面GET方式不能在body中传参数，但是可以在路径里的传参数。
    @ApiOperation("打印hello")
    @GetMapping("/hello1/{username}")
    public String hello1(@ApiParam("用户名") @PathVariable("username") String username){

        return "hello1 "+username;
    }

    @ApiOperation("打印hello")
    @PostMapping("/hello2")
    /**
     * Post方法参数一定要使用注解绑定请求中的参数，否则获取不到参数值
     * /hello2/{username}
     * @PathVariable("username")
     */
    public String hello2(@ApiParam("用户名") @RequestBody String username){

        return "hello2 "+username;
    }


    @ApiOperation("返回已设置user")
    @PostMapping("/returnuser")
    public User hello(@ApiParam("用户") User user){
        return user;
    }
}
