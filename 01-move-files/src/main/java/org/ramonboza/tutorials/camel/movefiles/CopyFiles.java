package org.ramonboza.tutorials.camel.movefiles;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 21/3/16.
 */
public class CopyFiles {

	private static final Logger LOGGER = Logger.getLogger("CopyFiles");

	public static void main(String[] args) throws Exception {
		final CamelContext camelContext = new DefaultCamelContext();
		try {
			camelContext.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("file:/tmp?noop=true").to("file:/tmp/camel");
				}
			});
			camelContext.start();
			Thread.sleep(4000);
			camelContext.stop();
		} catch (Exception camelException) {
			LOGGER.log(Level.SEVERE, "Exception trying to copy files - {0}", camelException.toString());
		}
	}
}
