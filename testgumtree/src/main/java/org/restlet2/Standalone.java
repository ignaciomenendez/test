package org.restlet2;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Extractor;
import org.restlet.routing.Redirector;
import org.restlet.routing.Router;

public class Standalone extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public synchronized Restlet createInboundRoot() {

        Router router = new Router(getContext());
                
        router.attach("/getmales", UsersData.class);
        router.attach("/getolder", UsersDates.class);

        return router;
    }

}
   