package com.geek.world.week5.hastodo1;

import java.util.concurrent.CompletableFuture;

/**
 * <h3>geek</h3>
 *
 * @classname:CompletableFutureMethod4
 * @author:xiaodong
 * @date:2021-05-26 10:48:54
 * @description:CompletableFuture的方式获取值
 */
public class CompletableFutureMethod4 {

    public static void main(String[] args) {
        int result1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 333; }).thenApplyAsync(v-> v + 111).join();
        System.out.println(result1);
    }
}
