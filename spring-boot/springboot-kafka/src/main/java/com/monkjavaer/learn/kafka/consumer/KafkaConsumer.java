package com.monkjavaer.learn.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

/**
 * @author monkjavaer
 * @date 2021/12/3
 */
@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(id = "myId", topics = "topic1")
    public void listen(String msg) {

        //没有提交偏移量，导致每次都从配置的earliest起始位置读取
        log.info("==================listen msg: {} ===================", msg);
    }


    @KafkaListener(topics = "topic2")
    public void listen2(String msg, Acknowledgment ack) {

        log.info("==================listen2 msg: {} ===================", msg);

        //手动提交偏移量
        ack.acknowledge();
    }

    @KafkaListener(topics = "sendCallbackMsg")
    public void sendCallbackMsg(String msg, Acknowledgment ack) {

        log.info("==================sendCallbackMsg msg: {} ===================", msg);

        //手动提交偏移量
        ack.acknowledge();
    }
}
