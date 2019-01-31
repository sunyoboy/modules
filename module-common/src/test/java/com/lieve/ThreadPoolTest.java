package com.lieve;
/**
 * @version 1.0
 * @since 2019/1/31 下午8:57
 */

import java.lang.invoke.MethodHandles;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolTest {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());


    final static ThreadPoolExecutor poolExecutor =
        new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    final static ThreadLocal<LocalVariable> localVariable =
        new ThreadLocal<LocalVariable>();

    static class LocalVariable {
        private Long[] vars = new Long[1024 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    localVariable.set(new LocalVariable());
                    logger.info("use local variable");
                    localVariable.remove();
                }
            });

            Thread.sleep(5000);
        }
        logger.info("pool execute over");
    }

}
