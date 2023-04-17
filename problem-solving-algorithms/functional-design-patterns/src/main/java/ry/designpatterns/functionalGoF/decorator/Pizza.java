package ry.designpatterns.functionalGoF.decorator;

public interface Pizza {
	
	default String bakePizza() { // use default to replace basic class
		return "Basic Pizza";
	};

	static Pizza withChickenTikka(Pizza pizza) {
		return new Pizza() {
			@Override
			public String bakePizza() {
				return pizza.bakePizza() + " with chicken";
			}
		};
	}

	static Pizza withProsciutto(Pizza pizza) {
		return new Pizza() {
			@Override
			public String bakePizza() {
				return pizza.bakePizza() + " with prosciutto";
			}
		};
	}
}