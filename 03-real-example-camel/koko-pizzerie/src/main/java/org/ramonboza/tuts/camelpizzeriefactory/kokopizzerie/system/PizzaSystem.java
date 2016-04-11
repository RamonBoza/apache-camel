package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.system;

import org.apache.activemq.command.ActiveMQQueue;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 4/4/16.
 */
@Service
public class PizzaSystem {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final Logger LOGGER = Logger.getLogger(PizzaSystem.class.getName());


    public PizzaSystem(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void register(final Pizza pizza) {
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createObjectMessage(pizza);
                return message;
            }
        });
    }

}
