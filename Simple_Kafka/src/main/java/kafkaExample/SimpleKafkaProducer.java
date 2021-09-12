package kafkaExample;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleKafkaProducer {
	public static void main(String[] args) {
		
		//Setup properties for Kafka Producer
		Properties kafkaProps = new Properties();
		
		//List of brokers to connect to
		kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		//Serializer class used to convert Keys to Byte Arrays
		kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		
		//Serializer class used to convert Messages to Byte Arrays
		kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		
		//Create a Kafka producer from configuration
		KafkaProducer<String,String> simpleProducer = new KafkaProducer<>(kafkaProps);
		
		//Publish 10 messages at 2 second intervals with a random key
		try {
			int startKey = (new Random()).nextInt(1000);
			
			for(int i=startKey;i<startKey+10;i++) {
				
				//create a producer Record
				ProducerRecord<String,String> kafkaRecord = new ProducerRecord<>(
						"kafka.learning.orders", 		//Topic name
						String.valueOf(i), 				//Key for the message
						"This is order " + i 			//Message Content
						);
				
				System.out.println("Sending Message : "+kafkaRecord.toString());
				
				//publish to kafka
				simpleProducer.send(kafkaRecord);
				
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			simpleProducer.close();
		}
	}
}
