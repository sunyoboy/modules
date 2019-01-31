package com.lieve;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/1/31 下午5:52
 */

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadLocalTest {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());


    public static class Task implements Runnable {

        private ThreadLocal threadLocal = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return "this is the initial value";
            }
        };

        @Override
        public void run() {
            logger.info("{}",threadLocal.get());
            threadLocal.set((int) (Math.random() * 1000D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            logger.info("{}",threadLocal.get());
            logger.info("{}",Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Task sharedRunnableInstance = new Task();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }
}
