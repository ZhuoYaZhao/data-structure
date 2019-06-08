package main.AQS;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static final int threadCount = 200;

    public static void main(String[] args) {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(10000);
        // 一次只能允许执行的线程数量。
        final Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    semaphore.acquire();// 获取一个许可，所以可运行线程数量为20/1=20
//                    System.out.println("availablePermits:" + semaphore.availablePermits());

                    test(threadnum);
//                    System.out.println(b);
                    semaphore.release();// 释放一个许可
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }

            });

        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        long l = System.currentTimeMillis();

        System.out.println(l + " threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
