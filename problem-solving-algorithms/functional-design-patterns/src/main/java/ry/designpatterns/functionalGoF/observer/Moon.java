package ry.designpatterns.functionalGoF.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Moon {

	public static void main(final String[] args) {
		final Moon moon = new Moon();

		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println("We made it!");
			}
		});

		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println("They're distracted, lets invade earth!");
			}
		});

		moon.land("An asteroid");
		moon.land("Apollo 11");
	}

	private final List<LandingObserver> observers = new CopyOnWriteArrayList<>();

	public void land(final String name) {
		for (final LandingObserver observer : this.observers) {
			observer.observeLanding(name);
		}
	}

	public void startSpying(final LandingObserver observer) {
		this.observers.add(observer);
	}

}