package org.restlet2;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class App {

	public static void main(String[] args) {
	    try {
	        // Create a new Component.
	        Component component = new Component();

	        // Add a new HTTP server listening on port 8182.
	        component.getServers().add(Protocol.HTTP, 8196);

	        // Attach the sample application.
	        component.getDefaultHost().attach(new Standalone());

	        // Start the component.
	        component.start();
	    } catch (Exception e) {
	        // Something is wrong.
	        e.printStackTrace();
	    }
	}
	   
}
