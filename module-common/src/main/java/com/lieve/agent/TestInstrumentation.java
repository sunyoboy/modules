package com.lieve.agent;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/2/1 下午6:09
 */

public class TestInstrumentation {

    public static void main(String[] args) {
        sayHello();
        sayWorld("world!");
        System.out.println(new TransClass().getNumber());
    }

    public static void sayHello() {
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
            System.out.println("hello!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("this method cost : " + (endTime - startTime) +  "ms.");
    }

    public static void sayWorld(String world) {
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
            System.out.println(world);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("this method cost : " + (endTime - startTime) +  "ms.");
    }

}
