package com.example.springtransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 关于分布式事务可以了解下BASE和TCC的概念
 *
 * @author monkjavaer
 * @date 2021/4/15
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentService studentService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO student (name, age) VALUES ('华为',23)");
    }

    /**
     * transactionManager属性一般是DataSourceTransactionManager
     */
    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO student (name, age) VALUES ('小米',23)");
        throw new RollbackException();
    }

    /**
     * FUN3 方法内部调用有事务处理的方法，事务不会回滚，方法内部调用没有走AOP代理，所以不会被增强，所以不会有事务的支持。
     */
    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
    }

    /**
     *  再加一层事务解决
     */
    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void invokeInsertThenRollback2() throws RollbackException {
        insertThenRollback();
    }

    /**
     * 把自己的实例注入进来
     */
    @Override
    public void invokeInsertThenRollback3() throws RollbackException {
        studentService.insertThenRollback();
    }

    /**
     * 获取当前代理，这样写避免了自己调用自己的实例
     */
    @Override
    public void invokeInsertThenRollback4() throws RollbackException {
        ((StudentServiceImpl)(AopContext.currentProxy())).insertThenRollback();
    }

}
