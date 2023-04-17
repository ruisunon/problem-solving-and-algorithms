package com.rygrids.designpatterns.modernjava.decorator;

public class ChickenTikkaPizza extends PizzaDecorator {
    protected ChickenTikkaPizza(Pizza pizza) {
        super(pizza);
    }
 
    @Override
    public String bakePizza() {
        return super.bakePizza() + " with chicken topping";
    }
}
 