package kafkaExample;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SimpleKafakaConsumer {
	public static void main(String[] args) {
		
		//Setup properties for Kafka Consumer
		Properties kafkaProps = new Properties();
		
		//List of brokers to connect to
		kafkaProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		//Deserializer class used to convert Byte Arrays to String
		kafkaProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		
		//Deserializer class used to convert Byte Arrays to string
		kafkaProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		
		//Consumer Group ID for this consumer
		kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka-java-consumer");
		
		//Set to consume from the earliest message, on start when no offset is available in Kafka
		kafkaProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		//Create a Consumer
		KafkaConsumer<String,String> simpleConsumer = new KafkaConsumer<>(kafkaProps);
		
		//Subscribe to the kafka.learning.orders topics
		simpleConsumer.subscribe(Arrays.asList("kafka.learning.orders"));
		
		//Keep on pull new messages
		while(true) {
			//Pull the msgs with 100mS timeout
			ConsumerRecords<String,String> messages = simpleConsumer.poll(Duration.ofMillis(100));
			
			for(ConsumerRecord<String,String> message:messages) {
				System.out.println("Message fetched: "+message.toString());
			}
		}
		
		
	}
}
