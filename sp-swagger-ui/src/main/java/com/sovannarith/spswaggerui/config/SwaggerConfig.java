package com.sovannarith.spswaggerui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sovannarith.spswaggerui.controller"))
                .paths(PathSelectors.ant("/v1/api/**"))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                        .code(5000)
                        .message("Internal Server Error")
                        .build(), new ResponseMessageBuilder()
                        .code(2000)
                        .message("KK")
                        .build()
                        ));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Taing Y RESTful API",
                "I made this for Ms. Taing Y LOL",
                "V1.0",
                "Terms of service",
                new Contact("Taing Y Official", "https://www.facebook.com/tainge.srun", ""),
                "License of API", "API license URL", Collections.emptyList());
    }




    private SecurityScheme securityScheme() {
        GrantType grantType = new AuthorizationCodeGrantBuilder()
                .tokenEndpoint(new TokenEndpoint("AUTH_SERVER" + "/token", "oauthtoken"))
                .tokenRequestEndpoint(
                        new TokenRequestEndpoint("AUTH_SERVER" + "/authorize", "CLIENT_ID", "CLIENT_ID"))
                .build();

        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
                .grantTypes(Arrays.asList(grantType))
                .scopes(Arrays.asList(scopes()))
                .build();
        return oauth;
    }
    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations"),
                new AuthorizationScope("foo", "Access foo API") };
        return scopes;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes())))
                .forPaths(PathSelectors.regex("/foos.*"))
                .build();
    }
}
