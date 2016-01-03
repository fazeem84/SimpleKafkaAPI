/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.test;

import org.middlewave.simplekafkaintegrator.kafkatopic.KafkaTopicCreator;

/**
 *
 * @author fazeem
 */
public class KafkaTopicCreatorTest {
    public static void main(String[] args) {
        new KafkaTopicCreator().createTopic("localhost",2181,"test");
    }
    
}
