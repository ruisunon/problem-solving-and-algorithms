package ry.designpatterns.functionalGoF.decorator;

public interface Boat {

	    public void createBoat();

	    default public Boat addPaddles() {
	        System.out.println("Adding paddles to the boat");
	        return this;
	    }

	    default public Boat addSails() {
	        System.out.println("Adding sails to the boat");
	        return this;
	    }

	    default public Boat addEngine() {
	        System.out.println("Adding an engine to the boat");
	        return this;
	    }
}
