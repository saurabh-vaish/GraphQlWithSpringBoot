package com.srv.app.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigGraphiql implements WebMvcConfigurer {

//    for showing ui for graphql
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/graphiql").setViewName(
                "forward:/graphiql/index.html");
    }
}