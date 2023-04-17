package ry.designpatterns.functionalGoF.decorator;

public class PizzaPizza {

	public static void main(String[] args) {
		Pizza pizza = new ChickenTikkaPizza(new PizzaBase());
		String finishedPizza = pizza.bakePizza();   //Basic Pizza with chicken topping
		System.out.println(finishedPizza);
		 
		pizza = new ChickenTikkaPizza(new ProsciuttoPizza(new PizzaBase()));
		finishedPizza  = pizza.bakePizza();  //Basic Pizza with prosciutto with chicken topping
		System.out.println(finishedPizza);
		
		////////////////
		String finishedPizzaNew = PizzaDecoratorNew.bakePizza(new PizzaBase(),Pizza::withChickenTikka, Pizza::withProsciutto);
		System.out.println(finishedPizzaNew);
		 		
	}

}
