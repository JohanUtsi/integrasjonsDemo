package com.eksempel.fagsystem.config;

import com.eksempel.fagsystem.controllers.AvtaleController;
import com.eksempel.fagsystem.controllers.BonusController;
import com.eksempel.fagsystem.controllers.KundeController;
import com.eksempel.fagsystem.controllers.RegNummerController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(BonusController.class);
        register(KundeController.class);
        register(RegNummerController.class);
        register(AvtaleController.class);
    }
}
