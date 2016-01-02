# SimpleKafkaAPI
Java-API which helps programmers to create Kafka Consumer and Kafka producer and Integrate with their apps easily

 Developers can Integrate KafkaConsumer with their app using minimal code

 KafkaConsumerProperties consumerProperties = new KafkaConsumerProperties("localhost",2181);
 KafkaConsumer consumer = new KafkaConsumer(consumerProperties);
 consumer.startTopicConsumerThread("TopicName");
 
 Developers has to Use Interface ConsumerListener and implement   
 public String receiveMessage(String message)  method  to listen to kafka read event.
 
 To initiate Producer class use following code
 
import org.middlewave.simplekafkaintegrator.kafkaproducer.KafkaProducerClient;
import org.middlewave.simplekafkaintegrator.properties.KafkaProducerProperties;

KafkaProducerProperties producerProperties=new KafkaProducerProperties("localhost",9092);
KafkaProducerClient client=new KafkaProducerClient(producerProperties);

Using KafkaProducerClient's sendMessage(Topic, message); function developers can send messages to a particular topic

Developers can use org.middlewave.simplekafkaintegrator.kafkatopic.KafkaTopicCreator.createTopic("TopicName"); to create a topic
  
  
 
 
