package testandoapis.app.support.config;

import org.aeonbits.owner.Config;

import javax.security.auth.login.Configuration;

@Config.Sources({"classpath:properties/local.properties","classpath:properties/${ENV}.properties"})
public interface ServerConfig extends Config {

    @Key("api.urlBase")
    String urlBase();

    @Key("api.path")
    String urlPath();

    int port();

}
