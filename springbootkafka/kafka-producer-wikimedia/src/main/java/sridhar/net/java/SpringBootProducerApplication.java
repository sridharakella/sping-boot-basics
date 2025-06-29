package sridhar.net.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication  implements CommandLineRunner {
    private final WikiMediaChangesProducer wikiMediaChangesProducer;

    public SpringBootProducerApplication(WikiMediaChangesProducer wikiMediaChangesProducer) {
        this.wikiMediaChangesProducer = wikiMediaChangesProducer;
    }
    // https://stream.wikimedia.org/v2/stream/recentchange

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikiMediaChangesProducer.sendMessage();

    }
}
