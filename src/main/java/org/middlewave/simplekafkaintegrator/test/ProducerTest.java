/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.test;

import org.middlewave.simplekafkaintegrator.kafkaproducer.KafkaProducerClient;
import org.middlewave.simplekafkaintegrator.properties.KafkaProducerProperties;

/**
 *
 * @author fazeem
 */
public class ProducerTest {
    public static void main(String[] args) {
        KafkaProducerProperties producerProperties=new KafkaProducerProperties("localhost",9092);
        KafkaProducerClient client=new KafkaProducerClient(producerProperties);
      
        client.sendMessage("Test", "Test msag1....");
        
    }
    
}
