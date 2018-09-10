package kafkaApi.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import kafkaApi.Entities.ProducerSong;

public class crudStep {
    @Given("^I want to create a song$")
    public void iWantToCreateASong() {
        ProducerSong producer= new ProducerSong();
        producer.createSong(15L,"Paradise","Pancho","Paquita","Pop");
    }
}
