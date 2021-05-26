package com.geek.world.week5.hastodo1;

/**
 * <h3>geek</h3>
 *
 * @classname:WaitMethod7
 * @author:xiaodong
 * @date:2021-05-26 11:40:15
 * @description:通过wait设置超时时间的方法，获取值
 */
public class WaitTimeOutMethod8 {
    private static int actul = 111;

    public static void main(String[] args) throws InterruptedException {
        WaitTimeOutMethod8 method7 = new WaitTimeOutMethod8();
        new Thread(() -> {
            try {
                Thread.sleep(4000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (method7) {
                actul = 888;
            }
        }).start();
        synchronized (method7) {
            method7.wait(5000);
            System.out.println(actul);
        }

    }
}
