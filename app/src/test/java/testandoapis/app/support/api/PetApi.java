package testandoapis.app.support.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import testandoapis.app.support.domain.Pet;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;



public class PetApi {
    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "v3/pet/findByStatus?status={status}";
    private static final String PET_ENDPOINT = "v3/pet/{id}";
    private static final String CREATE_PET_ENDPOINT = "v3/pet";

    public List<Pet> getPetsAvailabe(String status){
        return given().
                pathParam("status", status).
                when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
                then().
                extract().body().jsonPath().getList("", Pet.class);
    }

    public void deleteExtraPets(String status) {
        List<Integer> petIds = given().
                pathParam("status", status).
                when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
                thenReturn().
                path("id");

        List<Integer> petsToKeep = Arrays.asList(1,2,4,7,8,9,10);

        for(int petId : petIds) {
            if (!petsToKeep.contains(petId)) {
                given().pathParam("id", petId).delete(PET_ENDPOINT).then().statusCode(HttpStatus.SC_OK);
            }
        }
    }
    public Response getPetsResponse(String status){
        return given().
                pathParam("status", status).
                when().
                get(FIND_PETS_BY_STATUS_ENDPOINT);
    }
}
