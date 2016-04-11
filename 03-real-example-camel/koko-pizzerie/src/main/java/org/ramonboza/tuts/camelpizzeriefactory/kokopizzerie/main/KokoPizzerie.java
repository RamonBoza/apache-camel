package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.main;

import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.cashier.PizzaCashier;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.config.KokoPizzerieConfig;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.factory.PizzaFactory;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.store.PizzaStore;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.system.PizzaSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 4/4/16.
 */
public class KokoPizzerie {

    private final static Logger LOGGER = Logger.getLogger(KokoPizzerie.class.getName());

	private static final int NUMBER_OF_CASHIERS_AVAILABLE = 4;

	public static void main(final String[] args) {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(KokoPizzerieConfig.class);



        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_CASHIERS_AVAILABLE);
        for(int i = 0; i < NUMBER_OF_CASHIERS_AVAILABLE; i++) {
            executor.execute(ctx.getBean(PizzaCashier.class));
        }

        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE,"System cannot be shutdown");
        }finally {
            if(!executor.isTerminated()){
                executor.shutdownNow();
            }
        }
    }
}
