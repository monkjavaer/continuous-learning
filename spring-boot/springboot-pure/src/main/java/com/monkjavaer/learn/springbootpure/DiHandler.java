package com.monkjavaer.learn.springbootpure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author monkjavaer
 * @datetime 2022年 05月 02日 20:04
 */
@Component
@Slf4j
public class DiHandler {

    public String handleDi() {
        log.info("Di处理器 doing ......");
        return "Di handle successful";
    }
}
