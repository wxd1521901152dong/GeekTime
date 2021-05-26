package com.geek.world.week5.hastodo1;

/**
 * <h3>geek</h3>
 *
 * @classname:SleepMethod6
 * @author:xiaodong
 * @date:2021-05-26 11:32:32
 * @description:sleep堵塞main线程的方式来获取值
 */
public class SleepMethod6 {

    private static int actul = 111;
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(4000);
                actul = 666;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(actul);
    }
}
