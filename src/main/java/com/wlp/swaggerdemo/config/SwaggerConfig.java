package com.wlp.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
//启用Swagger,访问地址：http://127.0.0.1:8080/swagger-ui.html(swagger-ui源码下的html文件)
public class SwaggerConfig {

    //分组

    @Bean
    public Docket docket1001(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Group1001");
    }
    @Bean
    public Docket docket1002(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Group1002");
    }

    /**
     * 敲黑板：测试时，注意切换了环境后，也要使用对应端口访问
     */

    //创建Swagger实例 Docket
    @Bean
    public Docket docket(Environment environment){
        //Swagger开关，只有在激活dev环境时，才启用Swagger
        Profiles profiles = Profiles.of("dev");
        boolean enabled = environment.acceptsProfiles(profiles);

        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //设置是否自动启动Swagger，false时，将不能在浏览器中访问
                .enable(enabled)
                .select()
                /**
                 * Predicate接口实现类RequestHandlerSelectors：配置是扫描接口的方式
                 *  any()：扫描全部
                 *  none():不扫描
                 *  basePackage():指定要扫描的包
                 *  withClassAnnotation():扫描类上的注解，参数是一个注解的Class对象
                 *  withMethodAnnotation():扫描方法上的注解，参数是一个注解的Class对象
                 */
                .apis(RequestHandlerSelectors.basePackage("com.wlp.controller"))
                /**过滤路径
                 * Predicate接口实现类PathSelectors
                 * any():过滤全部
                 * none():不过滤
                 * ant():根据路径过滤
                 * regex():使用正则表达式匹配过滤
                 */
                .paths(PathSelectors.none())
                .build();
    }

    //配置Swagger信息
    public ApiInfo apiInfo(){
        //设置作者信息
        Contact contact = new Contact("wlp", "http://www.888.com", "88888888@qq.com");
        ApiInfo apiInfo = new ApiInfo("wlp学习Swagger"
                , "知识就是力量"
                , "1.0"
                , "http://www.888.com"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());

        return apiInfo;
    }
}
