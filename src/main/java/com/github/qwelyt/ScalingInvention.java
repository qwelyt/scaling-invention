package com.github.qwelyt;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class ScalingInvention {
    public static void main( final String[] args ) throws Exception{
       new ScalingInvention().run();
    }

    private void run() throws Exception{

       setupServer(8080, resourceConfig());
    }

   private ResourceConfig resourceConfig() {

      final ResourceConfig resourceConfig = new ResourceConfig();
      resourceConfig.register(new DataResource());
      return resourceConfig;
   }

   private void setupServer(final int port, final ResourceConfig resourceConfig) throws Exception {
      final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
      context.setContextPath("/");
      final Server jettyServer = new Server(port);
      jettyServer.setHandler(context);
      context.addServlet(new ServletHolder(new ServletContainer(resourceConfig)), "/*");
      jettyServer.start();
   }
}
