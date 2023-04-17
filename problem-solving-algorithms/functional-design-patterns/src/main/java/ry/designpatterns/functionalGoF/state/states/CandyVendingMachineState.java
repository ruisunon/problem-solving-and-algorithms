package ry.designpatterns.functionalGoF.state.states;

public interface CandyVendingMachineState {
    void insertCoin();
    void pressButton();
    void dispense();
}
