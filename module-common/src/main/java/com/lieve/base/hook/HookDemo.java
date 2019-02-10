package com.lieve.base.hook;


import java.io.IOException;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/7 下午8:57
 */
public class HookDemo {

    public static void main(String[] args) {
        HookDemo hookDemo = new HookDemo();
        hookDemo.start();
        try {
            int value = System.in.read();
            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("start application");
        ShutdownHook shutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }



}
class ShutdownHook extends Thread {

    @Override
    public void run() {
        System.out.println("do some clean tasks");
        System.out.println("this is shutdownhook");
    }
}
