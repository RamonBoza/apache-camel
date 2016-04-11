package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.cashier.PizzaCashier;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.factory.PizzaFactory;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.store.PizzaStore;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.system.PizzaSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * Created by ramon.boza on 4/4/16.
 */

@Configuration
public class KokoPizzerieConfig   {



    @Bean
    public PizzaStore pizzaStore(){
        return new PizzaStore(pizzaFactory());
    }

    @Bean
    public PizzaFactory pizzaFactory() {
        return new PizzaFactory();
    }

    @Bean
    public PizzaSystem pizzaSystem(){
        return new PizzaSystem(getJmsTemplate());
    }

    @Bean
    public PizzaCashier pizzaCashier(){
        return new PizzaCashier(pizzaStore(),pizzaSystem());
    }

    @Bean
    public JmsTemplate getJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(getConnectionFactory());
        jmsTemplate.setDefaultDestination(getDefaultDestination());
        return jmsTemplate;
    }

    @Bean
    public ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new CachingConnectionFactory(getAMQConnectionFactory());

        return connectionFactory;
    }

    @Bean
    public ConnectionFactory getAMQConnectionFactory() {
        ConnectionFactory AMQConnectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://192.168.99.100:61616");

        return AMQConnectionFactory;
    }

    @Bean
    public Destination getDefaultDestination() {
        Destination defaultDestination = new ActiveMQQueue("KokoPizzerie");
        return defaultDestination;
    }
}
