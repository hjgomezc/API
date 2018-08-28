package kafkaApi.glue;

import com.google.gson.JsonArray;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kafkaApi.Entities.JsonHelper;
import kafkaApi.Entities.Song;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.given;

public class topfiveStep {

    private String url = "http://localhost:7070/kafka-music/charts/top-five";
    private RequestSpecification query;
    Response getting;


    @Given("^that I want to search the top five of the songs$")
    public void thatIWantToSearchTheTopFiveOfTheSongs() {
        this.query = given().contentType("application/json");
    }

    @When("^I request the top five$")
    public void iRequestTheTopFive() {
        getting = this.query.when().get(url);
    }

    @Then("^I can see the top five songs$")
    public void iCanSeeTheTopFiveSongs() {
        Response response =  getting.then().assertThat().statusCode(200).and().extract().response();
        JsonHelper jsonHelper = new JsonHelper();
        Song song = new Song();
        JsonArray respondeList = jsonHelper.getJsonObjectListFromResponse(response);
        Assert.assertEquals("The expected result is 5 but was "+respondeList.size(),5,respondeList.size());
    }
}
