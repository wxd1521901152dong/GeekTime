package com.geek.world.week5.hastodo1;

import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <h3>geek</h3>
 *
 * @classname:whiileMethod5
 * @author:xiaodong
 * @date:2021-05-26 11:00:34
 * @description:朴素while轮询的方式取值
 */
public class whiileMethod5 {

    public static void main(String[] args) throws InterruptedException {
        Object5 object5 = new Object5();
        new Thread(object5).start();
        while (object5.getAge() == 0) {
        }
        System.out.println(object5.getAge());

    }
}
@Data
class Object5 implements Runnable {

    private volatile int age;

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            age = 555;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}