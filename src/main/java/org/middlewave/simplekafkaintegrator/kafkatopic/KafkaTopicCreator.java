/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.kafkatopic;

import java.util.Properties;
import kafka.admin.AdminUtils;
import org.I0Itec.zkclient.ZkClient;
import kafka.utils.ZKStringSerializer$;

/**
 *
 * @author fazeem
 */
public class KafkaTopicCreator {
    public void createTopic(String topic){
        ZkClient zkClient = new ZkClient("localhost:2181", 10000, 10000, ZKStringSerializer$.MODULE$);
        AdminUtils.createTopic(zkClient, topic, 10, 1, new Properties());
    }
}
