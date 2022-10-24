package testandoapis.app.support.api;

import org.apache.http.HttpStatus;
import testandoapis.app.support.domain.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserApi {
    private final String URL_POST_USUARIO = "/v3/user";
    private final String URL_GET_USUARIO = "/v3/user/{name}";


    public void criarUsuario(User userEsperado){
        given().body(userEsperado).
                when()
                .post(URL_POST_USUARIO)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public String capturarUsuarioUsername(User userEsperado){
      return   given().pathParam("name", userEsperado.getUsername()).
                when()
                .get(URL_GET_USUARIO)
                .thenReturn()
               .path("username");
    }

    public void deletar(){
        List<String> users = List.of("Jorge");
         for(String user:users){
             given().pathParam("name", user).
                     when()
                     .delete(URL_GET_USUARIO)
                     .then()
                     .statusCode(HttpStatus.SC_OK);
         }
    }
}
