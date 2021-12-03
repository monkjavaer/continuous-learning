package com.monkjavaer.learn.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
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
        log.info("==================listen msg: {} ===================", msg);
    }

}
