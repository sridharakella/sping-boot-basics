package sridhar.net.java;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;


@Service
public class WikiMediaChangesProducer {
    private static final Logger LOG = LoggerFactory.getLogger(WikiMediaChangesProducer.class);
private KafkaTemplate<String, String> kafkaTemplate;

//@Autowired is not requited, spring 4.3 we have single constructor automatically autowired
public WikiMediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
}

public void sendMessage() throws InterruptedException {
    String  topic = "wikimedia_recentchange";
    // to read the real time stream data from wikimedia, we event source

    EventHandler eventHandler = new WikiMediaChangesHandler(kafkaTemplate,topic);
    String url="https://stream.wikimedia.org/v2/stream/recentchange";
    EventSource.Builder builder= new EventSource.Builder(eventHandler, URI.create(url));
    EventSource eventSource = builder.build();
    eventSource.start();
    TimeUnit.MINUTES.sleep(10); // this will sleep after 10 mins


}

}
