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

    /**
     * 发送消息到已经初始化的topic
     * @return
     */
    @GetMapping("/sendMsg")
    private String sendMsg() {
        String msg = "hello kafka !";
        log.info("=====================send1 msg : {}========================", msg);
        kafkaTemplate.send("topic1", msg);
        return msg;
    }


    /**
     * 发送消息到不存在的topic
     * @return
     */
    @GetMapping("/sendMsg2")
    private String sendMsg2() {
        String msg = "hello kafka !";
        log.info("=====================send2 msg : {}========================", msg);
        kafkaTemplate.send("topic2", msg);
        return msg;
    }
}
