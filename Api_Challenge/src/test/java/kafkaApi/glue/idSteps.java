package kafkaApi.glue;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kafkaApi.Entities.JsonHelper;
import kafkaApi.Entities.Song;
import org.junit.Assert;
import sun.plugin.javascript.JSObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.core.StringContains.containsString;

public class idSteps {

    private String url = "http://localhost:7070/kafka-music/song/";
    private RequestSpecification query;
    Response getting;

    @Given("^that I want to find a song by id$")
    public void thatIWantToFindASongById() {
        this.query = given().contentType("application/json");

    }

    @When("^I request the song with the id \"([^\"]*)\"$")
    public void iRequestTheSongWithTheId(String arg0) {
        String urlTemp = url + arg0;
        getting = this.query.when().get(urlTemp);

    }

    @Then("^I can see the song with the name \"([^\"]*)\"$")
    public void iCanSeeTheSongWithTheName(String arg0) {
//        Response response = getting.then().assertThat().statusCode(200).and().extract().response();
////        JsonHelper jsonHelper = new JsonHelper();
////        Song song = new Song();
////        JsonObject responde = jsonHelper.getJsonObjectFromResponse(response);
////        Assert.assertEquals("bla "+responde.get("name"), (String) arg0, responde.get("name").getAsString());
        getting.then().assertThat().statusCode(200).and().assertThat().body(containsString(arg0));


    }

//    @Then("^I can see the song that belong to that id$")
//    public void iCanSeeTheSongThatBelongToThatId() {
//        getting.then().assertThat().statusCode(200).and().extract().response();
//
//
//    }

    @Then("^I can not see the song that belong to that id$")
    public void iCanNotSeeTheSongThatBelongToThatId() {
        getting.then().assertThat().statusCode(404).and().extract().response();
        // Write code here that turns the phrase above into concrete actions

    }


}
