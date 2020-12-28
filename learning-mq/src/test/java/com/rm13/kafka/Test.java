package com.rm13.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/26
 */
public class Test {

    public static void main(String[] args) {

        final Properties properties = new Properties();
        final KafkaConsumer kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Arrays.asList("rm13"));

        while (true) {

            final ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(10));

            for (ConsumerRecord consumerRecord : consumerRecords) {

            }
        }

    }

    public static void consumer() {
        final Properties properties = new Properties();
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList("rm13"));

        while (true) {
            final ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(Integer.MAX_VALUE));
            for (ConsumerRecord<String, String> record : consumerRecords) {
                System.out.println(record.topic() + "==" + record.partition() + "==" + record.key() + "==" + record.value());
            }
        }

    }

    public static void producer() {
        final Properties properties = new Properties();
        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        final ProducerRecord<String, String> record = new ProducerRecord<String, String>("rm13", "key-love", "value-love");
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                System.out.println("error");
            } else {
                System.out.println("process");
            }
        });
    }
}
