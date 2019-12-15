package com.srv.app.annotation.config;

import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.ServerException;

@Configuration
public class ConfigGraphiql  implements WebMvcConfigurer {

//    for showing ui for graphql
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/graphiql").setViewName(
//                "forward:/graphiql/index.html");
//    }


}