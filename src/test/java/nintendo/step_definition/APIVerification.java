package nintendo.step_definition;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import nintendo.pojo.SKUs;
import org.junit.Assert;


import static io.restassured.RestAssured.*;

public class APIVerification {

    Response response;

    @Given("I logged to SKUS api using {string} and {string} to generate Token")
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
                .then().extract().response();
    }

    @Then("Status code should be {int}")
    public void status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }


}
