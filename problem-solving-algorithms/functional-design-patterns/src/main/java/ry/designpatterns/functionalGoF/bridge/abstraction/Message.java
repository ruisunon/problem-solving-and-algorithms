package ry.designpatterns.functionalGoF.bridge.abstraction;

import ry.designpatterns.functionalGoF.bridge.implementation.MessageSender;

public abstract class Message {
    MessageSender messageSender;
    public Message(MessageSender messageSender){
        this.messageSender=messageSender;
    }
     abstract public void send();
}
