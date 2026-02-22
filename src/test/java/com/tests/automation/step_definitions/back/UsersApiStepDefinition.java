package com.tests.automation.step_definitions.back;
import com.tests.automation.api.ApiRequest;
import io.cucumber.java.en.*;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.Assert;
public class UsersApiStepDefinition {

    private Response response;
/*----------------------------------------------------------------------------------------------------------*/
    @When("I send a GET request to {string}")
    public void i_send_get_request(String endpoint) {
        response = ApiRequest.get(endpoint, null);
    }

    @Then("the response status code should be {int}")
    public void verify_status_code(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }
/*----------------------------------------------------------------------------------------------------------*/


}
