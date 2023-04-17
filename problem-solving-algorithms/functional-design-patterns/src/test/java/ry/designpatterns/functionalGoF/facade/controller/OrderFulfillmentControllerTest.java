package ry.designpatterns.functionalGoF.facade.controller;

import ry.designpatterns.functionalGoF.facade.servicefacade.OrderServiceFacadeImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderFulfillmentControllerTest {

    @Test
    public void testOrderProduct() throws Exception {
        OrderFulfillmentController controller=new OrderFulfillmentController();
        controller.facade=new OrderServiceFacadeImpl();
        controller.orderProduct(9);
        boolean result=controller.orderFulfilled;
        assertTrue(result);
    }
}