package ry.designpatterns.functionalGoF.strategy;

import java.util.Arrays;
import java.util.List;

public class StrategyPattern {
	// The strategy pattern defines a family of algorithms encapsulated in a driver
	// class usually known as Context and enables the algorithms to be
	// interchangeable. It makes the algorithms easily interchangeable, and provides
	// mechanism to choose the appropriate algorithm at a particular time.
	//
	// The algorithms (strategies) are chosen at runtime either by a Client or by
	// the Context. The Context class handles all the data during the interaction
	// with the client.
	// Strategy – Specifies the interface for all algorithms. This interface is used
	// to invoke the algorithms defined by a ConcreteStrategy.
	// Context – Maintains a reference to a Strategy object.
	// ConcreteStrategy – Actual implementation of the algorithm as per Strategy
	// interface
	
	 public static void main(String [] args) {
		 
	        //Create a List of Tax strategies for different scenarios
		    TaxStrategy pts=new PersonalTaxStrategy();
		    TaxStrategy ptps=new PersonalTaxPenaltyStrategy();
		    TaxStrategy ptrs=new PersonalTaxRebateStrategy();
	        List<TaxStrategy> taxStrategyList = Arrays.asList(pts, ptps, ptrs);
	 
	        //Calculate Tax for different scenarios with corresponding strategies
	        taxStrategyList.forEach(tax -> System.out.println(tax.calculateTax(30000.0)));
	        }
}
