package com.eksempel.integrasjonslosning.config;

import com.eksempel.integrasjonslosning.controllers.ForsikringsController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ForsikringsController.class);
    }
}
