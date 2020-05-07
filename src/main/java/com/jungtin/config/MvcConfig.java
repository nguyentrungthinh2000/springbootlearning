package com.jungtin.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig extends WebMvcAutoConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/vendor/**")
            .addResourceLocations("classpath:/static/vendor/");
    
        registry
            .addResourceHandler("/img/**")
            .addResourceLocations("classpath:/static/img/");
    }
}
