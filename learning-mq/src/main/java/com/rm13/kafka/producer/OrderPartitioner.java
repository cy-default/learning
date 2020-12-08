package com.rm13.kafka.producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

/**
 * 相同key发送到同一个分区中
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/12/3
 */
public class OrderPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> availablePartitions = cluster.availablePartitionsForTopic(topic);
        int index = key.hashCode() % availablePartitions.size();
        return availablePartitions.get(index).partition();
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
