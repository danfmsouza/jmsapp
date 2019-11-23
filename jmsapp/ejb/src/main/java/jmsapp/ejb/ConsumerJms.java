package jmsapp.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(
				propertyName = "destination",
				propertyValue = "java:/jmsapp/myqueue"
				)
})
public class ConsumerJms implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if(message instanceof TextMessage) {
			try {
				TextMessage msg = (TextMessage) message;
				System.out.println("======VAPO========");
				System.out.println("======VAPO========");
				System.out.println(msg.getText());
				System.out.println("======VAPO========");
				System.out.println("======VAPO========");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
