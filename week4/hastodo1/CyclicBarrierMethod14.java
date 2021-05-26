package com.geek.world.week5.hastodo1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <h3>geek</h3>
 *
 * @classname:CyclicBarrierMethod14
 * @author:xiaodong
 * @date:2021-05-26 14:35:50
 * @description: 利用CyclicBarrier将主线程和另开辟线程都暂停 ，来获取值
 */
public class CyclicBarrierMethod14 {
    private static CyclicBarrier c = new CyclicBarrier(2);
    private static int actul = 111;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                Thread.sleep(4000);
                actul = 141414;
                try {
                    c.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        c.await();
        System.out.println(actul);
    }

}
