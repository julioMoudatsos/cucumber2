package testandoapis.app.steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import testandoapis.app.support.api.UserApi;
import testandoapis.app.support.domain.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioStepdefinitions {
    private User userEsperado;
    private UserApi apiUsuario;

    public UsuarioStepdefinitions() {
        this.apiUsuario =  new UserApi();
    }

    @Quando("crio um usuario")
    public void crioUmUsuario() {
        userEsperado = User.builder().email("Julio@gmail.com").build();
       apiUsuario.criarUsuario(userEsperado);
    }

    @Entao("o usuario eh salvo no sistema")
    public void oUsuarioEhSalvoNoSistema() {
        String usernameAchado = apiUsuario.capturarUsuarioUsername(userEsperado);
        assertThat(usernameAchado,is(userEsperado.getUsername()));
    }


}
