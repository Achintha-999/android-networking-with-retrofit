package lk.acx.np.config;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig  extends ResourceConfig {
    public  AppConfig() {
        packages("lk.acx.np.controller");
        packages("lk.acx.np.middleware");
    }
}
