import java.io.IOException;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber2 {
// URL of the JMS server
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
// Name of the topic from which we will receive messages from = &quot; CL9&quot;
public static void main(String[] args) throws JMSException {
// Getting JMS connection from the server
ConnectionFactory connectionFactory1 = new ActiveMQConnectionFactory(url);
Connection connection1 = connectionFactory1.createConnection();
connection1.start();
Session session1 = connection1.createSession(false,
Session.AUTO_ACKNOWLEDGE);
Topic topic1 = session1.createTopic(&quot;CL10&quot;);
MessageConsumer consumer1 = session1.createConsumer(topic1);
Topic topic = session1.createTopic(&quot;CL9&quot;);
MessageConsumer consumer = session1.createConsumer(topic);
MessageListener listner1 = new MessageListener() {
public void onMessage(Message message1) {
try {
if (message1 instanceof TextMessage) {
TextMessage textMessage1 = (TextMessage) message1;
System.out.println(&quot;Received message&quot; + textMessage1.getText() +
&quot;&#39;&quot;);
}
} catch (JMSException e) {
System.out.println(&quot;Caught:&quot; + e);
e.printStackTrace();
}
}
};
consumer1.setMessageListener(listner1);
consumer.setMessageListener(listner1);
try {
System.in.read();
} catch (IOException e) {
e.printStackTrace();

}
connection1.close();
}
}
