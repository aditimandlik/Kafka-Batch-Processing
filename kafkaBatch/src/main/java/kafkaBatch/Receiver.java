package kafkaBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(id = "group-id", topics = "uber")
    public void receive(@Payload List<String> messages,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        for (int i = 0; i < messages.size(); i++) {
            LOGGER.info("Received message='{}' with partition-offset='{}'", messages.get(i),
                    partitions.get(i) + "-" + offsets.get(i));
        }
        LOGGER.info("All batch messages received");
    }
}
