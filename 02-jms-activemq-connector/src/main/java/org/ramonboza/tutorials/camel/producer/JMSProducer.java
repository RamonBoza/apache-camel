package org.ramonboza.tutorials.camel.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by ramon.boza on 21/3/16.
 */
public class JMSProducer {

    public static void main(String[] args) {
        try {

            // Create a ConnectionFactory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "failover://tcp://192.168.99.100:61616");
            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();
            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // Create the destination
            Destination destination = session.createQueue("test.queue");
            // Create a MessageProducer from the Session to the Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // Create a messages
            TextMessage message = session.createTextMessage("Helloworld");
            producer.send(message);
            session.close();
            connection.close();
            System.out.println("Message sent");

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
