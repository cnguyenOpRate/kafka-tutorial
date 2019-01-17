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

        props.put("bootstrap.servers", "broker:9092");
        props.put("acks", "1");
        props.put("delivery.timeout.ms", 30000);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < 100; i++) {
            // simply send a number as message key and payload
            producer.send(new ProducerRecord<>("test-topic", Integer.toString(i), Integer.toString(i)));
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.close();
    }
}
