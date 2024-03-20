package kafkaBatch;

//package com.memorynotfound.kafka;

//import com.memorynotfound.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaBatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBatchApplication.class, args);
	}

	@Autowired
	private Sender sender;

	@Override
	public void run(String... strings) throws Exception {
		for (int i = 1; i < 13; i++) {
			sender.send("message-" + i);
		}
	}
}