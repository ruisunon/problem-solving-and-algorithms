package ry.designpatterns.functionalGoF.facade.servicefacade;

import ry.designpatterns.functionalGoF.facade.domain.Product;
import ry.designpatterns.functionalGoF.facade.subcomponents.PaymentService;
import ry.designpatterns.functionalGoF.facade.subcomponents.ShippingService;
import ry.designpatterns.functionalGoF.facade.subcomponents.InventoryService;

public class OrderServiceFacadeImpl implements OrderServiceFacade{

    public boolean placeOrder(int pId){
        boolean orderFulfilled=false;
        Product product=new Product();
        product.productId=pId;
        if(InventoryService.isAvailable(product))
        {
            System.out.println("Product with ID: "+ product.productId+" is available.");
            boolean paymentConfirmed= PaymentService.makePayment();
            if(paymentConfirmed){
                System.out.println("Payment confirmed...");
                ShippingService.shipProduct(product);
                System.out.println("Product shipped...");
                orderFulfilled=true;
            }
        }
        return orderFulfilled;
    }
}
