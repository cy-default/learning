package com.rm13.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-12
 */
@Slf4j
public class Producer {

    private static final String BROKER_LIST = "47.103.195.210:9092";
    private static final String TOPIC_NAME = "topic-demo";
    private static final String PRODUCER_ID = "rm13.prd";

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Properties properties = new Properties();
        // key,value 序列化
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 服务器地址
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        // produeriD
        properties.setProperty(ProducerConfig.CLIENT_ID_CONFIG, PRODUCER_ID);
        // 1:leader ack;  0:no ack; -1:isr all ack
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "-1");
        // 保证消息的有序性时， 把该值设置位1， 不要求有序性的时候可以放大，提交吞吐量
        properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "1");
        KafkaProducer producer = new KafkaProducer(properties);


        ProducerRecord<String, String> producerRecord = null;
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            String key = "key"+i;
            String value = key+"==value"+i;
            producerRecord = new ProducerRecord<>(TOPIC_NAME, key , value);
            // 异步发送
            producer.send(producerRecord, (metadata, exception) -> {
                if (exception != null) {
                    log.error("KafkaProducer send error :{}", exception.getMessage());
                    return;
                }
                log.info("RecordMetadata callback:{}", metadata.toString());
            });
        }

        System.in.read();
    }
}
