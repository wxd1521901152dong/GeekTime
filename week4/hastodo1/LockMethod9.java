package com.geek.world.week5.hastodo1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h3>geek</h3>
 *
 * @classname:LockMethod9
 * @author:xiaodong
 * @date:2021-05-26 11:58:56
 * @description:通过lock超时锁的方法获取值
 */
public class LockMethod9 {
    private static ReentrantLock lock = new ReentrantLock();

    private static int actul = 111;
    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(4000);
                actul = 999;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();

        try {
            Thread.sleep(100);
            lock.tryLock(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(actul);
        }

    }
}
