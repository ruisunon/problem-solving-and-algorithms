package ry.designpatterns.functionalGoF.builder.director;

import ry.designpatterns.functionalGoF.builder.builders.HouseBuilder;
import ry.designpatterns.functionalGoF.builder.product.House;

public class ConstructionEngineer {
    private HouseBuilder houseBuilder;
    public ConstructionEngineer(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.paintHouse();
        this.houseBuilder.furnishHouse();
        return this.houseBuilder.getHouse();

    }
}
