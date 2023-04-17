package ry.designpatterns.functionalGoF.mediator.mediator;


import ry.designpatterns.functionalGoF.mediator.colleague.ArmedUnit;
import ry.designpatterns.functionalGoF.mediator.colleague.SoldierUnit;
import ry.designpatterns.functionalGoF.mediator.colleague.TankUnit;

public interface Commander {
   void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
    void setAttackStatus(boolean attackStatus);
    boolean canAttack();
    void startAttack(ArmedUnit armedUnit);
    void ceaseAttack(ArmedUnit armedUnit);
}
