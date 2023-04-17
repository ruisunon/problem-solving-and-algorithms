package ry.designpatterns.functionalGoF.mediator.mediator;

import ry.designpatterns.functionalGoF.mediator.colleague.ArmedUnit;
import ry.designpatterns.functionalGoF.mediator.colleague.SoldierUnit;
import ry.designpatterns.functionalGoF.mediator.colleague.TankUnit;
import org.junit.Test;

import static org.junit.Assert.*;


public class CommanderImplTest {

    @Test
    public void testMediator() throws Exception {
        Commander commander= new CommanderImpl();
        ArmedUnit soldierUnit=new SoldierUnit(commander);
        ArmedUnit tankUnit=new TankUnit(commander);
        commander.registerArmedUnits(soldierUnit, tankUnit);
        commander.startAttack(soldierUnit);
        commander.startAttack(tankUnit);
        commander.ceaseAttack(soldierUnit);
        commander.startAttack(tankUnit);
    }
}