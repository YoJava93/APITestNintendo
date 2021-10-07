package nintendo.step_definition;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import nintendo.pojo.SKUs;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class APIVerification {

    Response response;
    SKUs skus = new SKUs();

    @Given("I logged to SKUs api using {string} and {string} to generate Token")
    public void i_logged_to_SKUS_api_using_and(String username, String password) {
        // this is OPEN API and i do not need to authorize, but i wrote it just to simulate real work env
    }

    @When("I send a POST request using pojo class")
    public void i_send_a_post_request_usin_pojo_class() {

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



    @When("I sent a GET request with id {string} and i check response against JSon Schema Validation to verify if response body if it matches with requirements")
    public void i_sent_a_get_request_with_id(String inputId) {

         response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", inputId)
         .when()
                .get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}")
         .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("features/SKUSchema.json"))
         .extract().response();
    }

    @When("I  send DELETE request  with id {string}")
    public void i_send_path_params_with_id(String inputId) {

         response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", inputId)
         .when()
                .delete("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}")
         .then().extract().response();

    }

    @Then("I send GET request to id {string}")
    public void i_send_GET_request_to(String inputId) {

        response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", inputId)
        .when()
                .get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}")
                .then()
        .extract().response();
    }


    @When("I send GET request")
    public void i_send_GET_request() {
        response = given().accept(ContentType.JSON)
                .and()
        .when()
                .get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus")
                .then()
        .extract().response();
    }

    @When("I send POST request with invalid body")
    public void i_send_POST_request_with_invalid_body() {
        Map<String, String> map = new HashMap<>();
        map.put("ku","sleeping_bag");
        map.put("description","Outdoor");
        map.put("price","49.99");

        response = given().accept(ContentType.JSON)
                .and().body(map)
                .when()
                .post("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus")
                .then()
                .extract().response();
    }

    @When("I send GET request with invalid path params {string}")
    public void i_send_GET_request_with_invalid_path_params(String inputId) {

        response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", inputId)
                .when()
                .get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}")
                .then()
                .extract().response();
    }

    @When("I send GET request with POST body")
    public void i_send_GET_request_with_POST_body() {

        skus.setSku("sleeping_bag");
        skus.setDescription("Outdoor");
        skus.setPrice("49.99");

        response = given().accept(ContentType.JSON)
                .and().body(skus)
                .when()
                .get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus")
                .then()
                .extract().response();
    }

    @When("I send POST request with no body")
    public void i_send_POST_request_with_no_body() {

        response = given().accept(ContentType.JSON)
                .when()
                .post("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus")
                .then()
                .extract().response();
    }



}





