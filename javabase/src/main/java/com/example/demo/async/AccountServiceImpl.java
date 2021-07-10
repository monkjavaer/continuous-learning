package com.example.demo.async;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author monkjavaer
 * @date 2021/7/10
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public CompletableFuture<Void> add(int account, int amount) {

        System.out.println(account + "开始变更账户金额 : " + amount);

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(null);
    }
}
