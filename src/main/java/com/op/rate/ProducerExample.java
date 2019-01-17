package com.op.rate;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProducerExample {

    public static void main(String[] args) {
        new ProducerExample().sendMessage();
    }

    void sendMessage() {
        Properties props = new Properties();
        // TODO fill properties

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < 100; i++) {
            // TODO replace the parameters to send a message
            producer.send(new ProducerRecord<>(null, null, null));
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.close();
    }
}
