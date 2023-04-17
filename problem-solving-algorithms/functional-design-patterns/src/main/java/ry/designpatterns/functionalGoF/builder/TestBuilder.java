package ry.designpatterns.functionalGoF.builder;

public class TestBuilder {

	public static void main(String[] args) {
		new PersonBuilder()
		        .withSalutation("Mr.")
		        .withFirstName("John")
		        .withLastName("Doe")
		        .withIsFemale(false)
		        .createPerson();
		
		Person person = new AdvancedBuilder()
		        .with($ -> {
		            $.salutation = "Mr.";
		            $.firstName = "John";
		            $.lastName = "Doe";
		        })
		        .with($ -> $.isFemale = true).createPerson();

	}
	
//	Person person = new PersonBuilder()
//	        .with($ -> {
//	            $.salutation = "Mr.";
//	            $.firstName = "John";
//	            $.lastName = "Doe";
//	            $.isFemale = false;
//	            $.isHomewOwner = true;
//	            $.address =
//	                new PersonBuilder.AddressBuilder()
//	                    .with($_address -> {
//	                        $_address.city = "Pune";
//	                        $_address.state = "MH";
//	                        $_address.pin = "411001";
//	                    }).createAddress();
//	        })
//	        .createPerson();

}
