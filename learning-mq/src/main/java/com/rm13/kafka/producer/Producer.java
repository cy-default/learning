package com.rm13.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-12
 */
@Slf4j
public class Producer {

    private static final String BROKER_LIST = "106.14.121.77:9092";
    private static final String TOPIC_NAME = "rm13.demo2";
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
        // 自定义分区，保证相同key的消息发送到同一个分区，保证消息顺序性
        properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, OrderPartitioner.class.getName());

        KafkaProducer producer = new KafkaProducer(properties);

        ArrayList<ProducerRecord> list = new ArrayList<>();
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_NAME, "key-001", "key001-hello kafka001!");
        list.add(producerRecord);
        producerRecord = new ProducerRecord<>(TOPIC_NAME, "key-001", "key001-hello kafka002!");
        list.add(producerRecord);
        producerRecord = new ProducerRecord<>(TOPIC_NAME, "key-002", "key-002-hello kafka003!");
        list.add(producerRecord);
        producerRecord = new ProducerRecord<>(TOPIC_NAME, "key-002", "key-002-hello kafka004!");
        list.add(producerRecord);

        for (ProducerRecord record : list) {
            // 同步发送
            RecordMetadata RecordMetadata = (RecordMetadata) producer.send(record).get();
            log.info("RecordMetadata future:{}", RecordMetadata.toString());
        }

        for (ProducerRecord record : list) {
            // 异步发送
            producer.send(record, (metadata, exception) -> {
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
