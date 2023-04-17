package ry.designpatterns.functionalGoF.bridge.abstraction;

import ry.designpatterns.functionalGoF.bridge.implementation.EmailMessageSender;
import ry.designpatterns.functionalGoF.bridge.implementation.MessageSender;
import ry.designpatterns.functionalGoF.bridge.implementation.TextMessageSender;
import org.junit.Test;

import static org.junit.Assert.*;


public class MessageTest {

    @Test
    public void testSend() throws Exception {
      MessageSender textMessageSender=new TextMessageSender();
      Message textMessage=new TextMessage(textMessageSender);
      textMessage.send();

       MessageSender emailMessageSender=new EmailMessageSender();
       Message emailMessage=new TextMessage(emailMessageSender);
       emailMessage.send();
    }
}