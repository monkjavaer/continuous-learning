package com.example.demo.async;

import java.util.concurrent.CompletableFuture;

/**
 * @author monkjavaer
 * @date 2021/7/10
 */
public interface AccountService {
    /**
     * 变更账户金额
     * @param account 账户ID
     * @param amount 增加的金额，负值为减少
     */
    CompletableFuture<Void> add(int account, int amount);
}
