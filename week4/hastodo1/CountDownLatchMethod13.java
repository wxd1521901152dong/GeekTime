package com.geek.world.week5.hastodo1;

import java.util.concurrent.CountDownLatch;

/**
 * <h3>geek</h3>
 *
 * @classname:CountDownLatchMethod13
 * @author:xiaodong
 * @date:2021-05-26 14:16:57
 * @description:利用countDowLatch实现获取值
 */
public class CountDownLatchMethod13 {
    private static int actul = 111;
    private static CountDownLatch c = new CountDownLatch(1);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(4000);
                actul = 131313;
                c.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(actul);

    }

}
