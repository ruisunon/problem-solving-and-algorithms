package ry.designpatterns.functionalGoF.decorator;

public class ChickenTikkaPizza extends PizzaDecorator {
    protected ChickenTikkaPizza(Pizza pizza) {
        super(pizza);
    }
 
    @Override
    public String bakePizza() {
        return super.bakePizza() + " with chicken topping";
    }
}
 