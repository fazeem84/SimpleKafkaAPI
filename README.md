# SimpleKafkaAPI
Java-API which helps programmers to create Kafka Consumer and Kafka producer and Integrate with their apps easily

 Developers can Integrate KafkaConsumer with their app using minimal code.
 To use this API Developers has to download SimpleKafkaAPI-1.0-SNAPSHOT.jar from target folder,and put this jar in their class path along with other kafka dependent dependencies  mentioned in  pom file and start Integrating with the application.To integrate the app follow the instruction given here 

 KafkaConsumerProperties consumerProperties = new KafkaConsumerProperties("localhost",2181);
 KafkaConsumer consumer = new KafkaConsumer(consumerProperties);
 consumer.startTopicConsumerThread("TopicName");
 
 Developers has to implement Interface ConsumerListener and override   
 public String receiveMessage(String message)  method  to listen to kafka read event and add this class to consumers Listener List
 KafkaEventListener eventListener = new KafkaEventListener();
  consumer.addListener(eventListener);
  
  class KafkaEventListener implements ConsumerListener {

        @Override
        public String receiveMessage(String message) {
            System.out.println("Message recieved in the listener" + message);
            return message;
        }
    }

 
 
 
 To initiate Producer class use following code
 
import org.middlewave.simplekafkaintegrator.kafkaproducer.KafkaProducerClient;
import org.middlewave.simplekafkaintegrator.properties.KafkaProducerProperties;

KafkaProducerProperties producerProperties=new KafkaProducerProperties("localhost",9092);
KafkaProducerClient client=new KafkaProducerClient(producerProperties);

Using KafkaProducerClient's sendMessage(Topic, message); function developers can send messages to a particular topic

Developers can use org.middlewave.simplekafkaintegrator.kafkatopic.KafkaTopicCreator.createTopic("TopicName"); to create a topic
  
  
 
 
