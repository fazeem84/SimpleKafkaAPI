/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.kafkaconsumer;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import org.middlewave.simplekafkaintegrator.listener.ConsumerListener;
import org.middlewave.simplekafkaintegrator.properties.KafkaConsumerProperties;

/**
 *
 * @author fazeem
 */
public class KafkaConsumer {

    private final ConsumerConnector consumer;
    private ExecutorService executor;
    private KafkaConsumerProperties consumerProperties;
    private List<ConsumerListener> listerList=new ArrayList<ConsumerListener>();
    public KafkaConsumer(KafkaConsumerProperties consumerProperties) {
        consumer = Consumer.createJavaConsumerConnector(
                initConfig(consumerProperties));
        this.consumerProperties=consumerProperties;
    }

    private static ConsumerConfig initConfig(KafkaConsumerProperties consumerProperties) {
        Properties props = new Properties();
        props.put("zookeeper.connect", consumerProperties.getHostName()+":"+consumerProperties.getPort());
        props.put("group.id", consumerProperties.getGroupId());
        props.put("zookeeper.session.timeout.ms", consumerProperties.getTimeout());
        props.put("zookeeper.sync.time.ms", consumerProperties.getSyncTime());
        props.put("auto.commit.interval.ms", consumerProperties.getInterval());

        return new ConsumerConfig(props);
    }

    public void stopConsumer() {
        if (consumer != null) {
            consumer.shutdown();
        }
        if (executor != null) {
            executor.shutdown();
        }
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (Exception e) {
            System.out.println("Interrupted during shutdown, exiting uncleanly");
        }
    }
    public void startTopicConsumerThread(String topicName){
        this.startTopicConsumerThread(topicName,1);
    }
    public void startTopicConsumerThread(String topicName,int threadCount) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topicName, new Integer(threadCount));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topicName);

        // now launch all the threads
        //
        executor = Executors.newFixedThreadPool(threadCount);

        // now create an object to consume the messages
        //
        int threadNumber = 0;
        for (final KafkaStream stream : streams) {
            executor.submit(new MessageRecieverThread(stream, threadNumber,listerList));
            threadNumber++;
        }
    }
    public void addListener(ConsumerListener listner){
        listerList.add(listner);
    }
    public boolean removeListener(ConsumerListener listner){
        return listerList.remove(listner);
    }
}
