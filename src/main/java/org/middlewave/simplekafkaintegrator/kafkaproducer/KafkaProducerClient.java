/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.kafkaproducer;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.middlewave.simplekafkaintegrator.properties.KafkaProducerProperties;

/**
 *
 * @author fazeem
 */
public class KafkaProducerClient {

    private KafkaProducerProperties kafkaProducerProperties;
    private Producer<String, String> kafkaProducer;

    public KafkaProducerClient(KafkaProducerProperties kafkaProducerProperties) {
        this.kafkaProducerProperties = kafkaProducerProperties;
        ProducerConfig config = new ProducerConfig(initProperties(kafkaProducerProperties));
        this.kafkaProducer = new Producer<>(config);
    }

    public KafkaProducerProperties getKafkaProducerProperties() {
        return kafkaProducerProperties;
    }

    public void setKafkaProducerProperties(KafkaProducerProperties kafkaProducerProperties) {
        this.kafkaProducerProperties = kafkaProducerProperties;
    }

    public static Properties initProperties(KafkaProducerProperties kafkaProducerProperties) {
        Properties props = new Properties();
        props.put("metadata.broker.list", kafkaProducerProperties.getHostName() + ":" + kafkaProducerProperties.getPort());
        props.put("serializer.class", kafkaProducerProperties.getSerializerClass());
      //  props.put("partitioner.class", kafkaProducerProperties.getPartitionerClass());
        props.put("request.required.acks", kafkaProducerProperties.getAcknoweldgement());
        return props;
    }
    public void sendMessage(String topic,String message){
       try{
             KeyedMessage<String, String> data = new KeyedMessage<>(topic, message);
            this.kafkaProducer.send(data);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    public void stopProducer(){
        this.kafkaProducer.close();
    }
    public void sendMessage(){
          long events = 2;
        Random rnd = new Random();
 
        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "SimplePartitioner");
        props.put("request.required.acks", "1");
 
        ProducerConfig config = new ProducerConfig(props);
 
        Producer<String, String> producer = new Producer<String, String>(config);
 
        for (long nEvents = 0; nEvents < events; nEvents++) { 
               long runtime = new Date().getTime();  
               String ip = "192.168.2."+ rnd.nextInt(255); 
               String msg = runtime + ",www.example.com," + ip; 
               KeyedMessage<String, String> data = new KeyedMessage<String, String>("test", msg);
               producer.send(data);
        }
        producer.close();
    }
    
}
