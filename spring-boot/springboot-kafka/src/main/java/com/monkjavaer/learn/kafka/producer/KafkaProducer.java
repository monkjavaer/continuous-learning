package com.monkjavaer.learn.kafka.producer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        //这种方式只会创建1个分区和1个副本
        kafkaTemplate.send("topic2", msg);
        return msg;
    }

    /**
     * 发送消息到不存在的topic
     * @return
     */
    @GetMapping("/sendCallbackMsg/{message}")
    private String sendCallbackMsg(@PathVariable("message") String message) {

        log.info("=====================sendCallbackMsg msg : {}========================", message);

        kafkaTemplate.send("sendCallbackMsg", message).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("======= sendCallbackMsg 发送消息 {} 失败，失败原因：{}===================", message, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("======= sendCallbackMsg 发送消息 {} 成功，返回结果：{}===================", message, JSON.toJSONString(result));
            }
        });
        return message;
    }
}
