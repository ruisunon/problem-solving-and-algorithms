package ry.designpatterns.functionalGoF.visitor.visitors;


import ry.designpatterns.functionalGoF.visitor.structure.OperaMailClient;
import ry.designpatterns.functionalGoF.visitor.structure.SquirrelMailClient;
import ry.designpatterns.functionalGoF.visitor.structure.ZimbraMailClient;

public interface MailClientVisitor {
    void visit(OperaMailClient mailClient);
    void visit(SquirrelMailClient mailClient);
    void visit(ZimbraMailClient mailClient);
}
