package ry.designpatterns.functionalGoF.builder;

import java.util.function.Consumer;

public class AdvancedBuilder {
	 public String salutation;
	    public String firstName;
	    public String middleName;
	    public String lastName;
	    public String suffix;
	    public boolean isFemale;
	    public boolean isEmployed;
	    public boolean isHomewOwner;

	    public AdvancedBuilder with(Consumer<AdvancedBuilder> builderFunction) {
	        builderFunction.accept(this);
	        return this;
	    }


	    public Person createPerson() {
	        return new Person(salutation, firstName, middleName,
	                lastName, suffix, isFemale,
	                isEmployed, isHomewOwner);
	    }
}
