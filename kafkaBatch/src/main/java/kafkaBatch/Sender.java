package kafkaBatch;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//import java.util.logging.Logger;
import org.slf4j.Logger;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${app.topic}")
    private String topic;

    public void send(String message){
        LOGGER.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }

}