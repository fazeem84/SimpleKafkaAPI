# SimpleKafkaAPI
Java-API which helps programmers to create Kafka Consumer and Kafka producer and Integrate with their apps easily

 
 To use this API Developers has to download SimpleKafkaAPI-1.0-SNAPSHOT.jar from target folder,and put this jar in application class path along with other kafka  dependencies  mentioned in  pom file and developers can start Integrating with the application.To integrate the app follow the instruction given here .<br/>
Developers can Integrate KafkaConsumer with their app using minimal code.

import org.middlewave.simplekafkaintegrator.kafkaconsumer.KafkaConsumer;<br/>
import org.middlewave.simplekafkaintegrator.properties.KafkaConsumerProperties;<br/>

 KafkaConsumerProperties consumerProperties = new KafkaConsumerProperties("localhost",2181);<br/>
 KafkaConsumer consumer = new KafkaConsumer(consumerProperties);<br/>
 consumer.startTopicConsumerThread("TopicName");<br/>
 
 Developers has to implement Interface ConsumerListener  and override   
 public String receiveMessage(String message)  method  to listen to kafka read event and add the overrided class to consumers Listener List,so that the  event will be triggered receiveMessage().and developers can handle the event easily.
 
 KafkaEventListener eventListener = new KafkaEventListener();<br/>
 consumer.addListener(eventListener);<br/><br/>
 
  import org.middlewave.simplekafkaintegrator.listener.ConsumerListener;<br/>
  class KafkaEventListener implements ConsumerListener {

        @Override
        public String receiveMessage(String message) {
            System.out.println("Message recieved in the listener" + message);
            return message;
        }
    }

 
 
 
 To initiate Producer class use following code
 
import org.middlewave.simplekafkaintegrator.kafkaproducer.KafkaProducerClient;<br/>
import org.middlewave.simplekafkaintegrator.properties.KafkaProducerProperties;<br/>

KafkaProducerProperties producerProperties=new KafkaProducerProperties("localhost",9092);<br/>
KafkaProducerClient client=new KafkaProducerClient(producerProperties);<br/>

Using KafkaProducerClient's sendMessage(Topic, message); function developers can send messages to a particular topic

Developers can use org.middlewave.simplekafkaintegrator.kafkatopic.KafkaTopicCreator.createTopic("TopicName"); to create a topic
  
  
 
 
