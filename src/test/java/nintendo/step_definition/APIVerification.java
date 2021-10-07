package nintendo.step_definition;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import nintendo.pojo.SKUs;
import org.junit.Assert;
import static io.restassured.RestAssured.*;

public class APIVerification {

    Response response;

    @Given("I logged to SKUs api using {string} and {string} to generate Token")
    public void i_logged_to_SKUS_api_using_and(String username, String password) {
        // i do not have Authorization params, but i wrote it just to simulate real work env
    }

    @When("I send a post request using pojo class")
    public void i_send_a_post_request_usin_pojo_class() {
        SKUs skus = new SKUs();
        skus.setSku("sleeping_bag");
        skus.setDescription("Outdoor");
        skus.setPrice("49.99");

         response = given().accept(ContentType.JSON)
                .and().body(skus)
         .when()
                .post("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus")
         .then()
                 .extract().response();
    }


    @Then("Status code should be {int}")
    public void status_code_should_be(int statusCode) {
        //checking if response is as expected
        Assert.assertEquals("status code in not as expected ",statusCode, response.statusCode());
    }



    @When("I sent a get request with id {string} and i check response against JSon Schema Validation to verify if response body if it matches with requirements")
    public void i_sent_a_get_request_with_id(String inputId) {

        Integer id = Integer.valueOf(inputId);

         response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", id)
                .when()
                .get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("features/SKUSchema.json"))
                .extract().response();
    }

    @When("I  send DELETE request  with id {string}")
    public void i_send_path_params_with_id(String inputId) {

        Integer id = Integer.valueOf(inputId);

         response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", id)
                .when()
                .delete("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}")
                .then().extract().response();

    }

    @Then("I send GET request to {string}")
    public void i_send_GET_request_to(String inputId) {

        Integer id = Integer.valueOf(inputId);

        response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", id)
                .when()
                .get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("features/SKUSchema.json"))
                .extract().response();
    }
}
