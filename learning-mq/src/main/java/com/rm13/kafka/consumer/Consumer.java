package com.rm13.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-12
 */
public class Consumer {

    public static void main(String[] args) {
        Properties kafkaProperties = new Properties();
        kafkaProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        kafkaProperties.put("bootstrap.servers", "localhost:9092");
        kafkaProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "my-test");
        kafkaProperties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);

        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(kafkaProperties);
        consumer.subscribe(Arrays.asList("first-topic"));

        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(Duration.ofMillis(3000));
            for (ConsumerRecord<String, byte[]> record : records) {
                System.out.printf("topic:%s, partition:%s%n", record.topic(), record.partition());
            }
        }
    }
}
