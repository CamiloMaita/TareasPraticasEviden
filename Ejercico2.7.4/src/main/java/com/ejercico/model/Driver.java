package com.ejercico.model;

public class Driver {
	
	 private String name;
	    private String route;

	    public Driver(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getRoute() {
	        return route;
	    }

	    public void setRoute(String route) {
	        this.route = route;
	    }

    @Override
    public String toString() {
        return "Driver: " +
                 name + 
                ", route: " + route;
    }
}
