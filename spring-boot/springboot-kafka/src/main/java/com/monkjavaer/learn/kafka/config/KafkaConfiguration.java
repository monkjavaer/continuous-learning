package com.monkjavaer.learn.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author monkjavaer
 * @date 2021/12/3
 */
@Configuration
public class KafkaConfiguration {

    /**
     * NewTopic表示：在broker中不存在主题时，创建主题
     *
     * 可以设置分区数和副本数
     *
     * @return
     */
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic sendCallbackMsg() {
        return TopicBuilder.name("sendCallbackMsg")
                .partitions(8)
                .replicas(1)
                .build();
    }

}
