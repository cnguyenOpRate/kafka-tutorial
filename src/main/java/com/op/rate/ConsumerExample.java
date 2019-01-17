package com.op.rate;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ConsumerExample {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConsumerExample.class);

    public static void main(String[] args) {
        new ConsumerExample().readMessages();
    }

    void readMessages() {
        Properties props = new Properties();

        // TODO set the right properties to connect to your cluster


        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test-topic"));
        for (int i = 0; i < 10; i++) {

            // TODO call the right method on your consumer and read the data from a ConsumerRecords

        }

        consumer.close();
    }
}
