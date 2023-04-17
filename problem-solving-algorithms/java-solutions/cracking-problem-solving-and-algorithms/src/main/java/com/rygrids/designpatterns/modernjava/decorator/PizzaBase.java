package com.rygrids.designpatterns.modernjava.decorator;

public class PizzaBase implements Pizza {
    @Override
    public String bakePizza() {
    	
        return "Basic Pizza";
    }
}