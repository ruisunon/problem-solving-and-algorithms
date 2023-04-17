package com.rygrids.designpatterns.modernjava.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

// Instead of declaring an abstract class that will
// provide the template for decorations, we will create the decorator 
//that asks the user for functions that will decorate the component.
public class PizzaDecoratorNew {
	private final Function<Pizza, Pizza> toppings;

	// (currentToppings, nextTopping) -> currentToppings.andThen(nextTopping)
	private PizzaDecoratorNew(Function<Pizza, Pizza>... desiredToppings) {
		this.toppings = Stream.of(desiredToppings).reduce(Function.identity(), Function::andThen);

	}

	public static String bakePizza(Pizza pizza, Function<Pizza, Pizza>... desiredToppings) {
		return new PizzaDecoratorNew(desiredToppings).bakePizza(pizza);
	}

	private String bakePizza(Pizza pizza) {
		return this.toppings.apply(pizza).bakePizza();
	}

}