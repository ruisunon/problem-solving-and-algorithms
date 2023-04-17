package ry.designpatterns.functionalGoF.bridge.implementation;


public class TextMessageSender implements MessageSender {
    @Override
    public void sendMessage(){
        System.out.println("TextMessageSender: Sending text message...");
    }
}
