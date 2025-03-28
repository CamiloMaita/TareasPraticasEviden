package com.ejercico.Main;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ejercico.config.AppConfig;
import com.ejercico.model.Driver;
import com.ejercico.service.RouteAssignmentService;

public class Main {
   
	public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Driver driver = context.getBean(Driver.class);
        RouteAssignmentService routeAssignmentService = context.getBean(RouteAssignmentService.class);

        routeAssignmentService.assignRandomRoute(driver);

        System.out.println(driver);

        context.close();
    }
}
