package ry.designpatterns.functionalGoF.command.fp;

/**
 * The command for sending an email (a <b>ConcreteCommand1</b>).
 */
public class EmailCommand implements Runnable {

	private MessageDispather dispatcher;

	private MessageData messageData;

	public EmailCommand(MessageDispather dispatcher, MessageData messageData) {
		this.dispatcher = dispatcher;
		this.messageData = messageData;
	}

	@Override
	public void run() {
		dispatcher.send(messageData.getMessage(), messageData.getRecipients());
	}

}
