package com.serrodcal;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final Logger log = Logger.getLogger(GreetingResource.class);

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        log.info("Call to hello method");
        return Uni.createFrom().item("Hello");
    }

    @GET
    @Path("/greet/{greeting}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> greet(@PathParam("greeting") String greeting) {
        log.info("Call to greet method with greeting equals to " + greeting);
        return this.service.greet(greeting);
    }

}