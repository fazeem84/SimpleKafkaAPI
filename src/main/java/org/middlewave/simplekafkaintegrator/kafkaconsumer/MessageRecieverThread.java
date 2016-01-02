/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.kafkaconsumer;

import java.util.List;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import org.middlewave.simplekafkaintegrator.listener.ConsumerListener;

/**
 *
 * @author fazeem
 */
class MessageRecieverThread implements Runnable {

    private KafkaStream kafkaStream;
    private int threadId;
    private List<ConsumerListener> listenerList;
    public MessageRecieverThread(KafkaStream kafkaStream, int threadId,List<ConsumerListener> listenerList) {
        this.threadId = threadId;
        this.kafkaStream = kafkaStream;
        this.listenerList=listenerList;
    }
 
    public void run() {
        ConsumerIterator<byte[], byte[]> consumerIterator = kafkaStream.iterator();
        while (consumerIterator.hasNext()){
           String message= new String(consumerIterator.next().message());
            System.out.println("Thread " + threadId + ": " +message );
            for(ConsumerListener consumerListener:listenerList){
                consumerListener.receiveMessage(message);
            }
        }
        System.out.println("Shutting down Thread: " + threadId);
    }
    
}
