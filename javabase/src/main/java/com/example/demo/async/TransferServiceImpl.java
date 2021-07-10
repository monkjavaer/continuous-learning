package com.example.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author monkjavaer
 * @date 2021/7/10
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private  AccountService accountService;

    @Override
    public CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount) {
        // 异步调用add方法从fromAccount扣减相应金额
        return accountService.add(fromAccount, -1 * amount)
                // 然后调用add方法给toAccount增加相应金额
                .thenCompose(v -> accountService.add(toAccount, amount));
    }

}
