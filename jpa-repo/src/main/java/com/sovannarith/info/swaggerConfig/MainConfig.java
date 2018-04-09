package com.sovannarith.info.swaggerConfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MainConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Swagger
        registry.addViewController("/swagger").setViewName("/swagger/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
         * Static Resources store in the project
         */
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/");
        /*
         * Static Resources store outside the project
         */
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:/opt/FILES_MANAGEMENT/images/");
    }

}
