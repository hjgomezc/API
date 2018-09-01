package kafkaApi.CRUD;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;


public class KasfkaTest {

    KafkaProducer<Long,String> producer;

    public void setProducer(){
        Properties properties= new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("transactional.id", "my-transactional-id");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.LongSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(properties, new LongSerializer(), new StringSerializer());
    }

    public static  void main(String[] ppp){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.LongSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<Long, String> producer = new KafkaProducer<>(props);
        for (Long i = 0L; i < 100; i++)
            producer.send(new ProducerRecord<Long, String>("song-feed", i, "a"));

        producer.close();

    }
    public void sendSong(){
        producer.beginTransaction();
        //producer.send(new ProducerRecord<>("song-feed",,));
    }








}
