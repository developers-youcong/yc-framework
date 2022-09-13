package com.yc.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Component
public class KafkaConsumer {
    /**
     * @param record record
     * @KafkaListener(groupId = "testGroup", topicPartitions = {
     * @TopicPartition(topic = "topic1", partitions = {"0", "1"}),
     * @TopicPartition(topic = "topic2", partitions = "0",
     * partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))
     * },concurrency = "6")
     * //concurrency就是同组下的消费者个数，就是并发消费数，必须小于等于分区总数
     */
    @KafkaListener(topics = "my-replicated-topic", groupId = "testGroup1")
    public void listenJihuGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println("testGroup1 message: " + value);
        System.out.println("testGroup1 record: " + record);
        //手动提交offset，一般是提交一个banch，幂等性防止重复消息
        // === 每条消费完确认性能不好！
        ack.acknowledge();
    }

    //配置多个消费组
    @KafkaListener(topics = "my-replicated-topic", groupId = "testGroup2")
    public void listenJihuGroup2(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println("testGroup2 message: " + value);
        System.out.println("testGroup2 record: " + record);
        //手动提交offset
        ack.acknowledge();
    }

}
