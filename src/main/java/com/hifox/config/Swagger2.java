package com.hifox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * RESTful API的重磅好伙伴Swagger2，它可以轻松的整合到Spring Boot中，
 * 并与Spring MVC程序配合组织出强大RESTful API文档。它既可以减少我们
 * 创建文档的工作量，同时说明内容又整合入实现代码中，让维护文档和修改代
 * 码整合为一体，可以让我们在修改代码逻辑的同时方便的修改文档说明。另外
 * Swagger2也提供了强大的页面测试功能来调试每个RESTful API。
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hifox.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("第一课堂接口调用说明")
                .description("该文档仅供内部人员使用.")
                .termsOfServiceUrl("http://xxxx")
                .contact("xiezhongyong")
                .version("1.0")
                .build();
    }

}
