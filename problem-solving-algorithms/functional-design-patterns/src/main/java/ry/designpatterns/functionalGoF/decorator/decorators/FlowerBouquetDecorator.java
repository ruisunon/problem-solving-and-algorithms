package ry.designpatterns.functionalGoF.decorator.decorators;


import ry.designpatterns.functionalGoF.decorator.components.FlowerBouquet;

public abstract class FlowerBouquetDecorator extends FlowerBouquet {
    public abstract String getDescription();
}
