import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher1 {
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
public static void main(String[] args) throws JMSException {
ConnectionFactory connectionFactory2 = new ActiveMQConnectionFactory(url);
Connection connection2 = connectionFactory2.createConnection();
connection2.start();
// JMS messages are sent and received using a Session. We will
// create here a non-transactional session object. If you want
// to use transactions you should set the first parameter to &#39;true&#39;
Session session2 = connection2.createSession(false,
Session.AUTO_ACKNOWLEDGE);
Topic topic2 = session2.createTopic(&quot;IOT_Lab&quot;);
MessageProducer producer2 = session2.createProducer(topic2);

// We will send a small text message saying &#39;Hello&#39;
TextMessage message = session2.createTextMessage();
message.setText(&quot;This is a Message for Topic IOT_Lab&quot;);
// Here we are sending the message!
producer2.send(message);
System.out.println(&quot;Sent message &#39;&quot; + message.getText() + &quot;&#39;&quot;);
connection2.close();
}
}
