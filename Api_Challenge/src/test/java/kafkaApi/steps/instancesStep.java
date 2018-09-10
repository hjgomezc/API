package kafkaApi.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.core.StringContains.containsString;

public class instancesStep {

    private String url = "http://localhost:7070/kafka-music/instances";
    private RequestSpecification query;
    Response getting;


    @Given("^that I want to search the instances$")
    public void thatIWantToSearchTheInstances() {
        this.query = given().contentType("application/json");
    }

    @When("^I request the instances$")
    public void iRequestTheInstances() {
        getting = this.query.when().get(url);
    }

    @Then("^I can see the funcionalities of the api$")
    public void iCanSeeTheFuncionalitiesOfTheApi() {
        getting.then().assertThat().statusCode(200).extract().response().body().print();
    }

    @And("^verify instances$")
    public void verifyInstances() {
        getting.then().assertThat().body(containsString("storeNames"));
    }


}

