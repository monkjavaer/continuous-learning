package com.example.demo.lock;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author monkjavaer
 * @date 2021/8/10
 */
public class WaitNotifyTest {

    /**
     * 在多线程间共享的对象上使用wait
     */
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final int max = 10;

    public static void main(String[] args) {
        WaitNotifyTest test = new WaitNotifyTest();

        ThreadNotify threadNotify = test.new ThreadNotify("消费者：");
        threadNotify.start();

        for (int i = 0 ; i < 15; i++ ) {
            ThreadWait threadWait1 = test.new ThreadWait("生产者"+ i +"：");
            threadWait1.start();
        }

    }

    class ThreadWait extends Thread {
        //生产者
        public ThreadWait(String name){
            super(name);
        }

        @Override
        public void run() {
            synchronized (queue) {
                if (queue.size() > max) {
                    System.out.println("线程" + this.getName() + "消费队列满，开始等待队列空闲");
                    try {
                        long startTime = System.currentTimeMillis();
                        //挂起当前线程，释放通过同步块获取的对象锁。
                        queue.wait();
                        long endTime = System.currentTimeMillis();
                        System.out.println("线程" + this.getName() + "等待时间为：" + (endTime - startTime));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    //队列没有满，生产消息。
                    try {
                        String msg = UUID.randomUUID().toString();
                        queue.put(msg);
                        System.out.println("线程" + this.getName() + "生产一条数据：" + msg);

                        System.out.println("线程" + this.getName() + "发完消息，开始准备通知");
                        queue.notifyAll();
                        System.out.println("线程" + this.getName() + "通知结束");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class ThreadNotify extends Thread {
        //消费者
        public ThreadNotify(String name){
            super(name);
        }
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    if (queue.size() > 0) {
                        try {
                            // 给等待线程等待时间
                            sleep(3000);
                            System.out.println("线程" + this.getName() + "消费一条数据：" + queue.take());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("线程" + this.getName() + "开始准备通知");
                        queue.notifyAll();
                        System.out.println("线程" + this.getName() + "通知结束");
                    }else {
                        //消费完了，开始等待
                        try {
                            System.out.println("线程" + this.getName() + "消费完了，开始等待");
                            long startTime = System.currentTimeMillis();
                            queue.wait();
                            long endTime = System.currentTimeMillis();
                            System.out.println("线程" + this.getName() + "等待时间为：" + (endTime - startTime));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }
    }

}
