package com.geek.world.week5.hastodo1;

import java.util.concurrent.*;

/**
 * <h3>geek</h3>
 *
 * @classname:Method1
 * @author:xiaodong
 * @date:2021-05-26 09:44:29
 * @description: 线程池执行callable线程 future接收返回值，
 */
public class CallableMethod1 {

    public static void main(String[] args)  {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(4000);
                return 111;
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
