package com.rygrids.designpatterns.modernjava.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

	//  Instead of creating multiple concrete decorators and passing decorated object
	// as constructor argument,
    // you can pass an array (vararg) of Function<T,R>. 
	// Each member of an array represents the process of adding one of the boat accessories
public class BareBoat implements Boat {

	private Function<Boat, Boat> accDecorator;

	public BareBoat(Function<Boat, Boat>... accessories) {
		accDecorator = Stream.of(accessories).reduce(Function.identity(), Function::andThen);
	}

	@Override
	public void createBoat() {
		System.out.println("Creating a boat");
		accDecorator.apply(this);
	}
	
	// Let’s discuss what is happening in the constructor of modified BareBoat. It
	// takes an array of Function as argument. Each of those functions takes Boat as
	// input parameter. Function does something or perhaps does nothing and then
	// returns the Boat to the client. A Function that takes an argument, does
	// nothing and returns it is called an identity function.
	//
	// reduce() method is used to perform a reduction on elements of the stream. It
	// takes two arguments. First one is an identity value which in our case is
	// aforementioned identity function. Second argument is method reference to
	// Function::andThen. andThen() composes two functions and turns them into one.
	// As a result stream of functions is reduced to just one function and saved as
	// acc property.
	//
	// createBoat() applies the result of the reduction to current object and in
	// consequence runs all the functions that were passed as constructor argument
	// to BareBoat.
	//
	// Finally we can create another boat with all accessories offered by the
	// factory. This time we’ll do it the functional way.
	//
	public static void main(String [] args) {
	 Boat b = new BareBoat(Boat::addPaddles, Boat::addSails, Boat::addEngine);
	 b.createBoat();
	}
}