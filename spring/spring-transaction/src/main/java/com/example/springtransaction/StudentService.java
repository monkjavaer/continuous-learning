package com.example.springtransaction;

/**
 * @author monkjavaer
 * @date 2021/4/15
 */
public interface StudentService {

    public void insertRecord();

    /**
     * transactionManager属性一般是DataSourceTransactionManager
     */
    public void insertThenRollback() throws RollbackException;
    /**
     * FUN3 方法内部调用有事务处理的方法，事务不会回滚，方法内部调用没有走AOP代理，所以不会被增强，所以不会有事务的支持。
     */
    public void invokeInsertThenRollback() throws RollbackException;

    /**
     *  再加一层事务解决
     */
    public void invokeInsertThenRollback2() throws RollbackException ;

    /**
     * 把自己的实例注入进来
     */
    public void invokeInsertThenRollback3() throws RollbackException;

    /**
     * 获取当前代理，这样写避免了自己调用自己的实例
     */
    public void invokeInsertThenRollback4() throws RollbackException;
}
