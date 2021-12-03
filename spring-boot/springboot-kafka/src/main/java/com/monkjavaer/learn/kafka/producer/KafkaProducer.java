package com.monkjavaer.learn.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author monkjavaer
 * @date 2021/12/3
 */
@RestController
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/sendMsg")
    private String sendMsg() {
        String msg = "hello kafka !";
        log.info("=====================send msg : {}========================", msg);
        kafkaTemplate.send("topic1", msg);
        return msg;
    }

}
