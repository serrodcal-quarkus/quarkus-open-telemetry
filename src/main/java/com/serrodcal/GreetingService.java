package com.serrodcal;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import javax.inject.Singleton;

@Singleton
public class GreetingService {

    private static final Logger log = Logger.getLogger(GreetingService.class);

    public Uni<String> greet(String greeting) {
        log.info("Greeting is " + greeting);
        return Uni.createFrom().item("Hello " + greeting);
    }

}
