package org.ramonboza.tutorials.camel.camelnospring;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import sun.plugin2.message.Message;

import javax.jms.ConnectionFactory;

/**
 * Created by ramon.boza on 21/3/16.
 */
public class CamelActiveMQPlain {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin",
				"tcp://192.168.99.100:61616");

		try {
			context.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("activemq:queue:test.queue").to("stream:out");
				}
			});

			context.start();

			Thread.sleep(2000);
			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			context.stop();
		}
	}
}
