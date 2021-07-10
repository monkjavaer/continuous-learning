package com.example.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * @author monkjavaer
 * @date 2021/7/10
 */
@Service
public class Client implements CommandLineRunner {

    @Autowired
    private TransferService transferService;
    private final static int A = 1000;
    private final static int B = 1001;

    public void syncInvoke() throws ExecutionException, InterruptedException {
        // 同步调用
        transferService.transfer(A, B, 100).get();
        System.out.println("同步调用转账完成！");
    }

    public void asyncInvoke() {
        // 异步调用
        transferService.transfer(A, B, 100)
                .thenRun(() -> System.out.println("异步调用转账完成！"));
    }

    @Override
    public void run(String... args) throws Exception {
        syncInvoke();
        asyncInvoke();
    }
}
