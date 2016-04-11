package org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.system;

import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.model.pizzas.Pizza;
import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.model.pizzas.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 4/4/16.
 */
@Service
public class PizzaSystem {

    @Autowired
    private JmsTemplate jmsTemplate;

    public PizzaSystem(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void register(final PizzaOrder pizza) {
        this.jmsTemplate.send(session -> {
            Message message = session.createObjectMessage(pizza);
            return message;
        });
    }

}
