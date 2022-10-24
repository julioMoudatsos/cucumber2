package testandoapis.app.support.config;

import org.aeonbits.owner.Config;

import javax.security.auth.login.Configuration;

@Config.Sources({"classpath:properties/${ENV}.properties"})
public interface ServerConfig extends Config {

    @Key("api.base.uri")
    String urlBase();

    @Key("api.base.path")
    String urlPath();

    int port();

}
