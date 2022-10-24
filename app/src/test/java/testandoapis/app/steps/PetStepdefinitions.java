package testandoapis.app.steps;


import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import testandoapis.app.support.api.PetApi;
import testandoapis.app.support.domain.Pet;
import testandoapis.app.support.domain.User;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class PetStepdefinitions {

    private Pet petEsperado;
    private List<Pet> listapetEsperado;

    private PetApi api;

    private Response responsePet;

    public PetStepdefinitions() {
        this.api = new PetApi();
    }

    @Dado("tenha lista de pets")
    public void tenhaListaDePets() {
        petEsperado = Pet.builder().build();
        System.out.println("Fim do teste");
    }

    @Quando("pesquiso os pets a {word}")
    public void pesquisoOsPetsAAvailabe(String status) {
        listapetEsperado = api.getPetsAvailabe(status);
    }


    @Entao("me retorna uma lista de pets")
    public void meRetornaUmaListaDePets() {
        assertThat(listapetEsperado, is(not(empty())));
    }

    @E("chama uma lista de animais {word}")
    public void chamaUmaListaDeAnimaisAvailable(String status) {
        Response petsResponsesponse = api.getPetsResponse(status);
        listapetEsperado = petsResponsesponse.body().jsonPath().getList("", Pet.class);
        petsResponsesponse.then().body(
                "size()", is(listapetEsperado.size()),
                "findAll{it.status == '"+status+"'}.size()",is(listapetEsperado.size())
        );
    }

    @Dado("a lista de pets {word} esta vazio")
    public void aListaDePetsSoldEstaVazio(String status) {
        api.deleteExtraPets(status);
    }

    @Entao("me retorna uma lista com {}")
    public void meRetornaUmaListaCom(int quantidade) {
      assertThat(listapetEsperado.size(),is(quantidade));
    }


    @Dado("que eu possua animais {word}")
    public void queEuPossuaAnimaisAvailable(String status) {

    }

    @Quando("pesquiso por todos os animais {word}")
    public void pesquisoPorTodosOsAnimaisAvailable(String status) {
        responsePet = api.getPetsResponse(status);

    }

    @Entao("recebo a lista com {int} animais {word}")
    public void receboAListaComAnimaisAvailable( int quantidade, String status) {
         responsePet.
                 then()
                 .statusCode(HttpStatus.SC_OK).
                 body(
                         "size()",is(quantidade),
                 "findAll {it.status == '"+status+"'}.size()", is(quantidade)
         );
    }

    @E("{int} animais possuem o nome {word}")
    public void animaisPossuemONomeLion(int quantidade,String nome) {
        responsePet.then().statusCode(HttpStatus.SC_OK).
                body(
                        "findAll{it.name.contains('"+nome+"')}.size()", is(quantidade)
                );
    }


}
