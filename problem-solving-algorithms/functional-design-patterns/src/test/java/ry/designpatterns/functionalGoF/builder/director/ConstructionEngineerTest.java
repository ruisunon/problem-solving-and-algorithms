package ry.designpatterns.functionalGoF.builder.director;

import ry.designpatterns.functionalGoF.builder.builders.HouseBuilder;
import ry.designpatterns.functionalGoF.builder.builders.ConcreteHouseBuilder;
import ry.designpatterns.functionalGoF.builder.builders.PrefabricatedHouseBuilder;
import ry.designpatterns.functionalGoF.builder.product.House;
import org.junit.Test;

public class ConstructionEngineerTest {

    @Test
    public void testConstructHouse() throws Exception {
        HouseBuilder concreteHouseBuilder = new ConcreteHouseBuilder();
        ConstructionEngineer engineerA = new ConstructionEngineer(concreteHouseBuilder);
        House houseA = engineerA.constructHouse();
        System.out.println("House is: "+houseA);
        PrefabricatedHouseBuilder prefabricatedHouseBuilder = new PrefabricatedHouseBuilder();
        ConstructionEngineer engineerB = new ConstructionEngineer(prefabricatedHouseBuilder);
        House houseB = engineerB.constructHouse();
        System.out.println("House is: "+houseB);
    }
}