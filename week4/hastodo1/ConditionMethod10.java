package com.geek.world.week5.hastodo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h3>geek</h3>
 *
 * @classname:ConditionMethod10
 * @author:xiaodong
 * @date:2021-05-26 12:12:48
 * @description:通過lock condition的方式获取值
 */
public class ConditionMethod10 {
    private static Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int actul = 111;
    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(4000);
                actul = 101010;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(actul);
        }
    }
}
