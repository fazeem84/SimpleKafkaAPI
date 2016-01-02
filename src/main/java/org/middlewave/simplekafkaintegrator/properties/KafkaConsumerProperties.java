/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.properties;

/**
 *
 * @author fazeem
 */
public class KafkaConsumerProperties {

   
    String hostName = "localhost";
    int port = 2181;

    String groupId="Group1";
    String timeout = "400";
    String syncTime = "200";
    String interval = "1000";

   
    /**
     * 
     * @param hostName
     * @param port
     * @param topic 
     */
    public KafkaConsumerProperties(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;

    }
    /**
     * 
     * @param hostName
     * @param port
     * @param topic
     * @param groupId
     * @param timeout
     * @param syncTime
     * @param interval 
     */
    public KafkaConsumerProperties(String hostName, int port,  String groupId, String timeout, String syncTime, String interval) {
        this.hostName = hostName;
        this.port = port;
       
        this.groupId = groupId;
        this.timeout = timeout;
        this.syncTime = syncTime;
        this.interval = interval;
    }
    /**
     * 
     * @return 
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 
     * @param groupId 
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    /**
     * 
     * @return 
     */
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

   

    @Override
    public String toString() {
        return "KafkaConsumerProperties{" + "hostName=" + hostName + ", port=" + port +", groupId=" + groupId + ", timeout=" + timeout + ", syncTime=" + syncTime + ", interval=" + interval + '}';
    }
    
    
}
