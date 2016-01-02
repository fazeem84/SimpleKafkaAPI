/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.properties;

/**
 *
 * @author fazeem
 */
public class KafkaProducerProperties {
    private String hostName = "localhost";
    private int port = 9092;
    private String serializerClass="kafka.serializer.StringEncoder";
    private String partitionerClass=org.middlewave.simplekafkaintegrator.kafkaproducer.SimplePartitioner.class.getName();
    private String acknoweldgement="1";

    public KafkaProducerProperties(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getAcknoweldgement() {
        return acknoweldgement;
    }

    public void setAcknoweldgement(String acknoweldgement) {
        this.acknoweldgement = acknoweldgement;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPartitionerClass() {
        return partitionerClass;
    }

    public void setPartitionerClass(String partitionerClass) {
        this.partitionerClass = partitionerClass;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSerializerClass() {
        return serializerClass;
    }

    public void setSerializerClass(String serializerClass) {
        this.serializerClass = serializerClass;
    }

    @Override
    public String toString() {
        return "KafkaProducerProperties{" + "hostName=" + hostName + ", port=" + port + ", serializerClass=" + serializerClass + ", partitionerClass=" + partitionerClass + ", acknoweldgement=" + acknoweldgement + '}';
    }
    
    
    
}
