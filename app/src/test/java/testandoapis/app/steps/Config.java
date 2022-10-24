package testandoapis.app.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import testandoapis.app.support.api.UserApi;
import testandoapis.app.support.config.ManagerConfig;
import testandoapis.app.support.config.ServerConfig;

public class Config {
    private UserApi userApi;

    public Config() {
        this.userApi = new UserApi();
    }

    @Before
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        ServerConfig propriedadesDaApi = ManagerConfig.getConfiguracoes();

        RestAssured.baseURI = String.format("%s:%d",propriedadesDaApi.urlBase(),propriedadesDaApi.port());
        RestAssured.basePath = propriedadesDaApi.urlPath();
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization",getToken()).
                setContentType(ContentType.JSON).
                build();

    }


    @After("@deletarUsuarioCriado")
    public void deletandoUsuarioCriado(){
       userApi.deletar();
    }

    private String getToken() {
        return "grant access";
    }

}
