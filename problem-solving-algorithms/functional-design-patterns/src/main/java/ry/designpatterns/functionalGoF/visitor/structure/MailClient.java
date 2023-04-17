package ry.designpatterns.functionalGoF.visitor.structure;

import ry.designpatterns.functionalGoF.visitor.visitors.MailClientVisitor;

public interface MailClient {
    void sendMail(String[] mailInfo);
    void receiveMail(String[] mailInfo);
    boolean accept(MailClientVisitor visitor);
}
