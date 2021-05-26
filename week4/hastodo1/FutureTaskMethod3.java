package com.geek.world.week5.hastodo1;

import java.util.concurrent.*;

/**
 * <h3>geek</h3>
 *
 * @classname:FutureTaskMethod2
 * @author:xiaodong
 * @date:2021-05-26 10:21:38
 * @description:线程池启动futureTask的方式获取主线程中另开线程的值
 */
public class FutureTaskMethod3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<Integer> task = new FutureTask<>(new Callable() {
            @Override
            public Integer call() throws Exception {
                int autal = 333;
                Thread.sleep(4000);
                return autal;
            }
        });
        executorService.submit(task);
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
