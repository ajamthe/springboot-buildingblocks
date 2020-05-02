package com.stacksimplify.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.stacksimplify.restservices"))
                .paths(PathSelectors.ant("/users/**")).build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Stack Simplify User Management service")
                .description("This page lists all APIs of the User Management")
                .version("2.0")
                .contact(
                        new Contact("Ash Jam", "https://google.com", "abc@bbc.com")
                ).license("License 2.0")
                .licenseUrl("http://license.google.com")
                .build();
    }

    //Swagger Metadata URL: http://localhost:8080/v2/api-docs
    //Swager UI URL: http://localhost:8080/swagger-ui.html
}
