package com.ejercico.service;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejercico.model.Driver;



public class RouteAssignmentServiceImpl implements RouteAssignmentService {

    private final RouteProvider routeProvider;

    @Autowired
    public RouteAssignmentServiceImpl(RouteProvider routeProvider) {
        this.routeProvider = routeProvider;
    }

    @Override
    public void assignRandomRoute(Driver driver) {
        List<String> routes = routeProvider.getRoutes();
        Random random = new Random();
        String randomRoute = routes.get(random.nextInt(routes.size()));
        driver.setRoute(randomRoute);
    }
}