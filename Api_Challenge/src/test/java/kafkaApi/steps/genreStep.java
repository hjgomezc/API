package kafkaApi.steps;

import com.google.gson.JsonArray;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kafkaApi.Entities.JsonHelper;
import kafkaApi.Entities.Song;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.given;

public class genreStep {

    private String url = "http://localhost:7070/kafka-music/charts/genre/";
    private RequestSpecification query;
    Response getting;

    @Given("^that I want to filter the songs by genre$")
    public void thatIWantToFilterTheSongsByGenre(){
        this.query = given().contentType("application/json");
    }

    @When("^I request to see the \"([^\"]*)\" songs$")
    public void iRequestToSeeTheSongs(String arg0)  {
        String urlTemp= url +arg0;
        getting = this.query.when().get(urlTemp);
    }

    @Then("^I can see the songs that belong to this genre$")
    public void iCanSeeTheSongsThatBelongToThisGenre() {
        Response response =  getting.then().assertThat().statusCode(200).and().extract().response();
        JsonHelper jsonHelper = new JsonHelper();
        Song song = new Song();
        JsonArray respondeList = jsonHelper.getJsonObjectListFromResponse(response);
        Assert.assertEquals("The expected result is 5 but was "+respondeList.size(),5,respondeList.size());

    }

    @Then("^I can see that there are no songs that belong to this genre$")
    public void iCanSeeThatThereAreNoSongsThatBelongToThisGenre() {
        Response response =  getting.then().assertThat().statusCode(404).and().extract().response();
    }
}
