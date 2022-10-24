package testandoapis.app.support.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import testandoapis.app.support.domain.Pedido;

import static io.restassured.RestAssured.given;

public class StoreApi {
    private final String GET_ORDER = "/v3/store/order/{id}";
    private final String POST_ORDER = "/v3/store/order";

    public Pedido criarPedido(Pedido pedido) {
       return   given().
                 body(pedido).when().
                 post(POST_ORDER).then().
                 statusCode(HttpStatus.SC_OK).extract().body().as(Pedido.class);

    }

    public Response ResponsePedido(int id) {
        return given().
                pathParam("id", id)
                .when()
                .get(GET_ORDER);
    }



}
