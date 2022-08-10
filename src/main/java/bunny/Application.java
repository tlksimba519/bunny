package bunny;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Application {

//	private final static String QUEUE_NAME = "test";
	private final static String EXCHANGE_NAME = "notification";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("eddie");
		factory.setPassword("Leo0826519");
		factory.setVirtualHost("test");
		Connection conn = factory.newConnection();
		Channel ch = conn.createChannel();
		ch.exchangeDeclare(EXCHANGE_NAME, "fanout");
//		ch.setDefaultConsumer(ch.);
//		ch.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Test from bunny~";
//		ch.basicPublish("", QUEUE_NAME, false, null, message.getBytes());
		ch.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
	}

}
