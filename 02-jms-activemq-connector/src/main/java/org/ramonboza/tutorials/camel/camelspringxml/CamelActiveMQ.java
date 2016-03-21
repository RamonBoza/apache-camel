package org.ramonboza.tutorials.camel.camelspringxml;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ramon.boza on 21/3/16.
 */
public class CamelActiveMQ {

    public static void main (String[] args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("camel.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(applicationContext,false);
        try {
            camelContext.start();
            Thread.sleep(2000);
        }finally {
            camelContext.stop();
        }
    }
}
