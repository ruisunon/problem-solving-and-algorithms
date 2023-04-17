package ry.designpatterns.functionalGoF.builder.builders;

import ry.designpatterns.functionalGoF.builder.product.House;

public interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void paintHouse();
    void furnishHouse();
    House getHouse();
}
