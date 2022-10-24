package testandoapis.app.steps;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import testandoapis.app.support.api.PetApi;
import testandoapis.app.support.api.StoreApi;
import testandoapis.app.support.domain.Pet;
import testandoapis.app.support.domain.Pedido;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoreStepdefinitions {

    private PetApi petApi;
    private StoreApi storeApi;

    private Pet petEsperado;
    private Pedido pedidoEsperado;

    public StoreStepdefinitions() {
        storeApi =  new StoreApi();
        petApi =  new PetApi();
    }

    @Dado("que eu possua animal {word}")
    public void queEuPossuaAnimalAvailable(String status) {
        petEsperado =  Pet.builder().name("Lord").status(status).build();
    }

    @Quando("faco o pedido desse animal")
    public void facoOPedidoDesseAnimal() {
        pedidoEsperado = Pedido.builder().id(4444).petId(petEsperado.getId()).build();
        storeApi.criarPedido(pedidoEsperado);

    }


    @Entao("o pedido eh {word}")
    public void oPedidoEhApproved(String statusPedido) {
        Response pedidoCapturado = storeApi.ResponsePedido(pedidoEsperado.getId());
        pedidoCapturado.then().body(
                "status",is(statusPedido)
        );
    }
}
