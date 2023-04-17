package ry.designpatterns.functionalGoF.facade.subcomponents;


import ry.designpatterns.functionalGoF.facade.domain.Product;

public class InventoryService {
    public static boolean isAvailable(Product product){
        /*Check Warehouse database for product availability*/
        return true;
    }
}
