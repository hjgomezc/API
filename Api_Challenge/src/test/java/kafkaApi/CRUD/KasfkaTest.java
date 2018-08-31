package kafkaApi.CRUD;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;


public class KasfkaTest {

    KafkaProducer<Long,String> producer;

    public void setProducer(){
        Properties properties= new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("transactional.id", "my-transactional-id");
        producer = new KafkaProducer(properties, new LongSerializer(), new StringSerializer());
    }
    public void sendSong(){
        producer.beginTransaction();
    }








}
