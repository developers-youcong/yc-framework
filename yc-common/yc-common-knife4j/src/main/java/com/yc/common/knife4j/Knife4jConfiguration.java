package com.yc.common.knife4j;

import cn.hutool.core.lang.Console;
import com.yc.common.core.base.constant.ApplicationConst;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @description:
 * @author: youcong
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;

    private static final String URL = "http://www.ycframework.com/";

    private static final String AUTHOR_EMAIL = "youcongtech@163.com";

    private static final String VERSION = "1.0";

    private static final String GROUP_NAME = "1.0版本";

    @Bean(value = "api")
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title(getTitle(applicationName))
                .description(getDesc(applicationName))
                .termsOfServiceUrl(URL)
                .contact(AUTHOR_EMAIL)
                .version(VERSION)
                .build();
    }


    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(getTitle(applicationName))
                        .description(getDesc(applicationName))
                        .termsOfServiceUrl(URL)
                        .contact(AUTHOR_EMAIL)
                        .version(VERSION)
                        .build())
                //分组名称
                .groupName(GROUP_NAME)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(getBasePackage(applicationName)))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * 包扫描自定义
     *
     * @param applicationName
     * @return
     */
    private String getBasePackage(String applicationName) {
        Console.log("applicationName:" + applicationName);
        String basePackage = "";
        switch (applicationName) {
            case ApplicationConst.AUTH:
                basePackage = ApplicationConst.KNIFE4J_AUTH_PACKAGE;
                break;
            case ApplicationConst.ADMIN:
                basePackage = ApplicationConst.KNIFE4J_ADMIN_PACKAGE;
                break;
            case ApplicationConst.CMS:
                basePackage = ApplicationConst.KNIFE4J_CMS_PACKAGE;
                break;
            case ApplicationConst.CRAWLER:
                basePackage = ApplicationConst.KNIFE4J_CRAWLER_PACKAGE;
                break;
            case ApplicationConst.FILE:
                basePackage = ApplicationConst.KNIFE4J_FILE_PACKAGE;
                break;
            case ApplicationConst.PLUGINS:
                basePackage = ApplicationConst.KNIFE4J_PLUGINS_PACKAGE;
                break;
            case ApplicationConst.WECHAT:
                basePackage = ApplicationConst.KNIFE4J_WECHAT_PACKAGE;
                break;
            default:
                basePackage = ApplicationConst.DEFAULT_PACKAGE;
                break;
        }
        Console.log("basePackage:" + basePackage);
        return basePackage;
    }

    /**
     * 服务名称
     *
     * @param applicationName
     * @return
     */
    private String getTitle(String applicationName) {
        Console.log("applicationName:" + applicationName);
        String title = "";
        switch (applicationName) {
            case ApplicationConst.AUTH:
                title = "统一认证服务";
                break;
            case ApplicationConst.ADMIN:
                title = "统一用户管理";
                break;
            case ApplicationConst.CMS:
                title = "统一内容管理";
                break;
            case ApplicationConst.CRAWLER:
                title = "统一爬虫管理";
                break;
            case ApplicationConst.FILE:
                title = "统一文件管理";
                break;
            case ApplicationConst.PLUGINS:
                title = "统一插件管理";
                break;
            case ApplicationConst.WECHAT:
                title = "微信生态管理";
                break;
            default:
                title = "默认应用管理";
                break;
        }
        Console.log("title:" + title);
        return title;
    }

    /**
     * 描述
     *
     * @param applicationName
     * @return
     */
    private String getDesc(String applicationName) {
        Console.log("applicationName:" + applicationName);
        String desc = "";
        switch (applicationName) {
            case ApplicationConst.AUTH:
                desc = "Auth API";
                break;
            case ApplicationConst.ADMIN:
                desc = "User API";
                break;
            case ApplicationConst.CMS:
                desc = "CMS API";
                break;
            case ApplicationConst.CRAWLER:
                desc = "Crawler API";
                break;
            case ApplicationConst.FILE:
                desc = "File API";
                break;
            case ApplicationConst.PLUGINS:
                desc = "Plugins API";
                break;
            case ApplicationConst.WECHAT:
                desc = "Wechat API";
                break;
            default:
                desc = "Default API";
                break;
        }
        Console.log("desc:" + desc);
        return desc;
    }
}
