package testandoapis.app.support.config;

import org.aeonbits.owner.ConfigCache;

public class ManagerConfig {

    private ManagerConfig(){}

    public static ServerConfig getConfiguracoes(){
        return ConfigCache.getOrCreate(ServerConfig.class);
    }

}
