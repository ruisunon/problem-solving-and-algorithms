package ry.designpatterns.functionalGoF.visitor.visitors;

import ry.designpatterns.functionalGoF.visitor.structure.OperaMailClient;
import ry.designpatterns.functionalGoF.visitor.structure.SquirrelMailClient;
import ry.designpatterns.functionalGoF.visitor.structure.ZimbraMailClient;

public class WindowsMailClientVisitor implements MailClientVisitor{
    @Override
    public void visit(OperaMailClient mailClient) {
        System.out.println("Configuration of Opera mail client for Windows complete");
    }

    @Override
    public void visit(SquirrelMailClient mailClient) {
        System.out.println("Configuration of Squirrel mail client for Windows complete");

    }

    @Override
    public void visit(ZimbraMailClient mailClient) {
        System.out.println("Configuration of Zimbra mail client for Windows complete");

    }
}
