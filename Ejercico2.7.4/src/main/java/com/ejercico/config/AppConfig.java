package com.ejercico.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ejercico.model.Driver;
import com.ejercico.service.RouteAssignmentService;
import com.ejercico.service.RouteAssignmentServiceImpl;
import com.ejercico.service.RouteProvider;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.ejercicio")
public class AppConfig {

    @Bean
    public Driver driver() {
        return new Driver("Camilo");
    }

    @Bean
    public RouteProvider routeProvider() {
        return new RouteProvider() {
            @Override
            public List<String> getRoutes() {
                return Arrays.asList("Route A", "Route B", "Route C","Route Z");
            }
        };
    }

    @Bean
    public RouteAssignmentService routeAssignmentService(RouteProvider routeProvider) {
        return new RouteAssignmentServiceImpl(routeProvider);
    }
}