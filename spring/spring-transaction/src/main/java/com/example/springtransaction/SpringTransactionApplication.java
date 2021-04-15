package com.example.springtransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * proxyTargetClass 基于接口还是基于类的
 *
 */
@EnableTransactionManagement(proxyTargetClass = false, mode = AdviceMode.PROXY)
@EnableAspectJAutoProxy(exposeProxy = true)
@Slf4j
@SpringBootApplication
public class SpringTransactionApplication implements ApplicationRunner {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        studentService.insertRecord();

        log.info("fun1 {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student WHERE name='华为'", Long.class));

        try {
            studentService.insertThenRollback();
        } catch (RollbackException e) {
            log.info("fun2 {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student WHERE name='小米'", Long.class));
        }


        try {
            studentService.invokeInsertThenRollback();
        } catch (RollbackException e) {
            log.info("fun3 {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student WHERE name='小米'", Long.class));
        }

        try {
            studentService.invokeInsertThenRollback4();
        } catch (RollbackException e) {
            log.info("fun5 {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student WHERE name='小米'", Long.class));
        }
    }
}
