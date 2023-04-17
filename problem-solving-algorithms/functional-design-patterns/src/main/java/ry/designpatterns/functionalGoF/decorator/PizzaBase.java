package ry.designpatterns.functionalGoF.decorator;

public class PizzaBase implements Pizza {
    @Override
    public String bakePizza() {
    	
        return "Basic Pizza";
    }
}