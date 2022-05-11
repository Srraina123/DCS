import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
public static void main(String[] args) throws JMSException {
ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
Connection connection = connectionFactory.createConnection();
connection.start();
Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
Topic topic = session.createTopic(&quot;CL9&quot;);
MessageProducer producer = session.createProducer(topic);
// We will send a small text message saying &#39;Hello&#39;
TextMessage message = session.createTextMessage();
message.setText(&quot;This is a Message for Topic CL9&quot;);
// Here we are sending the message!
producer.send(message);
System.out.println(&quot;Sent message &#39;&quot; + message.getText() + &quot;&#39;&quot;);
connection.close();

ConnectionFactory connectionFactory1 = new ActiveMQConnectionFactory(url);
Connection connection1 = connectionFactory1.createConnection();
connection1.start();

// JMS messages are sent and received using a Session. We will
// create here a non-transactional session object. If you want
// to use transactions you should set the first parameter to &#39;true&#39;
Session session1 = connection1.createSession(false,
Session.AUTO_ACKNOWLEDGE);
Topic topic1 = session1.createTopic(&quot;CL10&quot;);
MessageProducer producer1 = session1.createProducer(topic1);
// We will send a small text message saying &#39;Hello&#39;
TextMessage message1 = session1.createTextMessage();
message1.setText(&quot;This is a Message for Topic CL10&quot;);
// Here we are sending the message!
producer1.send(message1);
System.out.println(&quot;Sent message &#39;&quot; + message1.getText() + &quot;&#39;&quot;);
connection1.close();
}
}
