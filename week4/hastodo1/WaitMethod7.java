package com.geek.world.week5.hastodo1;


/**
 * <h3>geek</h3>
 *
 * @classname:WaitMethod7
 * @author:xiaodong
 * @date:2021-05-26 11:40:15
 * @description:通过wait，notifly的方式获取值
 */
public class WaitMethod7 {
    private static int actul = 111;

    public static void main(String[] args) throws InterruptedException {
        WaitMethod7 method7 = new WaitMethod7();
        new Thread(() -> {
            try {
                Thread.sleep(4000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (method7) {

                actul = 777;
                method7.notify();
            }
        }).start();
        synchronized (method7) {
            method7.wait();
            System.out.println(actul);
        }

    }
}
