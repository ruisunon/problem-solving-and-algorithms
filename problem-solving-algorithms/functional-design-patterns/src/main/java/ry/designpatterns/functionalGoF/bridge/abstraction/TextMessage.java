package ry.designpatterns.functionalGoF.bridge.abstraction;

import ry.designpatterns.functionalGoF.bridge.implementation.MessageSender;

public class TextMessage extends Message{

    public TextMessage(MessageSender messageSender){
        super(messageSender);
    }
    @Override
    public void send(){
      messageSender.sendMessage();
    }

}
