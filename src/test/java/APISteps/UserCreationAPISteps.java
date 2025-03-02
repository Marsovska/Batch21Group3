package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloadConstants;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserCreationAPISteps {
    RequestSpecification prepRequest;
    Response response;

    @Given("Request is prepared")
    @Given("Request is prepared using dynamic payload")
    public void request_is_prepared_using_dynamic_payload() {
        prepRequest = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY
                        , APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(APIPayloadConstants
                        .createUserPayloadJsonDynamic(ConfigReader.read("nameAPI")
                                , ConfigReader.read("email")
                                , ConfigReader.read("passwordAPI")));
    }

    @When("Post call is send for user creation")
    public void post_call_is_send_for_user_creation() {
        response = prepRequest.when().post(APIConstants.CREATE_USER_URI);
    }

    @Then("the status code received is {int}")
    public void the_status_code_received_is(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response {string} is {string}")
    public void the_response_is(String key, String expectedValue) {
        response.then().assertThat().body(key, equalTo(expectedValue));
    }

    @Given("Request is prepared with invalid email using dynamic payload")
    public void request_is_prepared_with_invalid_email_using_dynamic_payload() {
        prepRequest = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY
                        , APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(APIPayloadConstants
                        .createUserPayloadJsonDynamic(ConfigReader.read("nameAPI")
                                , "donnasimon.gmail.com"
                                , ConfigReader.read("passwordAPI")));
    }

    @Given("Request is prepared without password using dynamic payload")
    public void request_is_prepared_without_password_using_dynamic_payload() {
        prepRequest = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY
                        , APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(APIPayloadConstants
                        .createUserPayloadJsonDynamic(ConfigReader.read("nameAPI")
                                , ConfigReader.read("email")
                                , ""));

    }

    @Given("Request is prepared without name using dynamic payload")
    public void request_is_prepared_without_name_using_dynamic_payload() {
        prepRequest = given().header(APIConstants
                                .HEADER_CONTENT_TYPE_KEY
                        , APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(APIPayloadConstants.createUserPayloadJsonDynamic("", ConfigReader.read("email")
                        , ConfigReader.read("passwordAPI")));

    }

}