package com.geek.world.week5.hastodo1;

/**
 * <h3>geek</h3>
 *
 * @classname:JoinMethod12
 * @author:xiaodong
 * @date:2021-05-26 14:06:13
 * @description:用join方法实现获取值
 */
public class JoinMethod12 {
    private static int actul = 111;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
                actul = 111111;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        //用join不加超时时间的也可以
        //        thread.join();
        thread.join(5000);
        System.out.println(actul);

    }

}
