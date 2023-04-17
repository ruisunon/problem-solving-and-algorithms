package ry.designpatterns.functionalGoF.observer.observerimpl;

import java.math.BigDecimal;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void setBidAmount(Observer observer,BigDecimal newBidAmount);
}
