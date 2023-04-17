package ry.designpatterns.functionalGoF.bridge.abstraction;
import ry.designpatterns.functionalGoF.bridge.implementation.MessageSender;

public class EmailMessage extends Message{
    public EmailMessage(MessageSender messageSender){
        super(messageSender);
    }
    @Override
    public void send(){
        messageSender.sendMessage();
    }

}
