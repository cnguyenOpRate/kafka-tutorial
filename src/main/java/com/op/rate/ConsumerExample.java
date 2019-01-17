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

        props.put("bootstrap.servers", "broker:9092");
        props.put("group.id", "test-consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "500");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test-topic"));
        for (int i = 0; i < 10; i++) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.of(500, ChronoUnit.MILLIS));
            for (ConsumerRecord<String, String> record : records) {
                LOGGER.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());
            }
        }

        consumer.close();
    }
}
