package ry.designpatterns.functionalGoF.observer;

import java.math.BigDecimal;
import java.util.Observer;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void setBidAmount(Observer observer,BigDecimal newBidAmount);
}