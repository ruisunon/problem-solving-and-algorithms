package ry.designpatterns.functionalGoF.ChainofResponsibility;

        import ry.designpatterns.functionalGoF.ChainofResponsibility.handlers.BillingSupportHandler;
        import ry.designpatterns.functionalGoF.ChainofResponsibility.handlers.AbstractSupportHandler;
        import ry.designpatterns.functionalGoF.ChainofResponsibility.handlers.GeneralSupportHandler;
        import ry.designpatterns.functionalGoF.ChainofResponsibility.handlers.TechnicalSupportHandler;

public class RequestorClient {

    public  static AbstractSupportHandler getHandlerChain(){


        AbstractSupportHandler technicalSupportHandler = new TechnicalSupportHandler( AbstractSupportHandler.TECHNICAL);
        AbstractSupportHandler billingSupportHandler = new BillingSupportHandler(  AbstractSupportHandler.BILLING);
        AbstractSupportHandler generalSupportHandler = new GeneralSupportHandler(AbstractSupportHandler.GENERAL);

        technicalSupportHandler.setNextHandler(billingSupportHandler);
        billingSupportHandler.setNextHandler(generalSupportHandler);

        return technicalSupportHandler;
    }

}
