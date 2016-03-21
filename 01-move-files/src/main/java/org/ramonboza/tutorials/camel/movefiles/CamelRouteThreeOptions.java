package org.ramonboza.tutorials.camel.movefiles;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.ramonboza.tutorials.camel.movefiles.routes.FileTransferRouteBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.ramonboza.tutorials.camel.movefiles.routes.FileTransferRouteBuilder.FileTransferType.COPY_WITH_ARCHIVED_ORIGINALS;

/**
 * Created by ramon.boza on 21/3/16.
 */
public class CamelRouteThreeOptions {

	private static final Logger LOGGER = Logger.getLogger("CamelRouteThreeOptions");

	public static void main(String[] args) throws Exception {

		FileTransferRouteBuilder routeBuilder = new FileTransferRouteBuilder(COPY_WITH_ARCHIVED_ORIGINALS);

		final CamelContext camelContext = new DefaultCamelContext();
		try {
			camelContext.addRoutes(routeBuilder);
			camelContext.start();
			Thread.sleep(4000);
			camelContext.stop();
		} catch (Exception camelException) {
			LOGGER.log(Level.SEVERE, "Exception trying to copy files - {0}", camelException.toString());
		}
	}

}
