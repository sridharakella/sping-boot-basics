package com.example.sridhar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    // @KafkaListener(topics="consumer", groupId = "myGroup")
   // @KafkaListener(topics="wikimedia_recent change", groupId = "myGroup")
    @KafkaListener(topics="wikimedia_recent change", groupId = "myGroup")
    public void consume(String eventMessage)
    {
       logger.info( String.format("Event Message received --> %s " + eventMessage));
    }
}
