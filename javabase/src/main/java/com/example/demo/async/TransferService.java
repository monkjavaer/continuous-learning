package com.example.demo.async;

import java.util.concurrent.CompletableFuture;

/**
 * @author monkjavaer
 * @date 2021/7/10
 */
public interface TransferService {

    /**
     * 异步转账服务
     * @param fromAccount 转出账户
     * @param toAccount 转入账户
     * @param amount 转账金额，单位分
     */
    CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount);

}
