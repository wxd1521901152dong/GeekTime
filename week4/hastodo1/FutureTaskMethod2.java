package com.geek.world.week5.hastodo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <h3>geek</h3>
 *
 * @classname:FutureTaskMethod2
 * @author:xiaodong
 * @date:2021-05-26 10:21:38
 * @description:futureTask的方式获取主线程中另开线程的值
 */
public class FutureTaskMethod2 {

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new Callable() {
            @Override
            public Integer call() throws Exception {
                int autal = 222;
                Thread.sleep(4000);
                return autal;
            }
        });
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
