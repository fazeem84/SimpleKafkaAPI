package org.middlewave.simplekafkaintegrator.test;


import org.middlewave.simplekafkaintegrator.kafkaconsumer.KafkaConsumer;
import org.middlewave.simplekafkaintegrator.listener.ConsumerListener;
import org.middlewave.simplekafkaintegrator.properties.KafkaConsumerProperties;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author fazeem
 */
public class ConsumerTest {

    

    public static void main(String[] args) {
        KafkaConsumerProperties consumerProperties = new KafkaConsumerProperties("localhost",2181);
        KafkaConsumer consumer = new KafkaConsumer(consumerProperties);
        consumer.startTopicConsumerThread("Test");
        KafkaEventListener eventListener1 = new KafkaEventListener();
        consumer.addListener(eventListener1);

       
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException ie) {
        }
        consumer.stopConsumer();
    }
}
class KafkaEventListener implements ConsumerListener {

        @Override
        public String receiveMessage(String message) {
            System.out.println("Message recieved in the listener" + message);
            return message;
        }
    }
