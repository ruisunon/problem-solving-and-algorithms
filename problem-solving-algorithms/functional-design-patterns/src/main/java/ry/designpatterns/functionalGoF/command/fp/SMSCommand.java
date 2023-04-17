package ry.designpatterns.functionalGoF.command.fp;

/**
 * The command for sending a SMS (the <b>ConcreteCommand2</b>).
 *
 */
public class SMSCommand implements Runnable {

	private MessageDispather dispatcher;

	private MessageData messageData;

	public SMSCommand(MessageDispather dispatcher, MessageData messageData) {
		this.dispatcher = dispatcher;
		this.messageData = messageData;
	}

	@Override
	public void run() {
		dispatcher.send(messageData.getMessage(), messageData.getRecipients());
	}

}
