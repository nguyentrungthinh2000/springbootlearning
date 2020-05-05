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
    
    /*@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:jdbc/schema.sql")
            .addScript("classpath:jdbc/data.sql").build();
    }*/
    
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/learn_hibernate?useSSL=false");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUsername("hbstudent");
//        dataSource.setPassword("hbstudent");
//        return dataSource;
//    }
}
