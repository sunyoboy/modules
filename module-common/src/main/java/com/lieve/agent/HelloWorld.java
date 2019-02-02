package com.lieve.agent;

import java.lang.invoke.MethodHandles;

/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/2/2 上午10:35
 */

public class HelloWorld {


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("HelloWorld");

        /**
         * 输出： sun.misc.Launcher$AppClassLoader@18b4aac2
         */
        System.out.println(MethodHandles.lookup().lookupClass().getClassLoader());

        /**
         * /Users/sunlj/work/10-fengkong/modules/module-common/target/classes/com/lieve/agent/
         */
        System.out.println(MethodHandles.lookup().lookupClass().getResource("").getPath());
        System.out.println(MethodHandles.lookup().lookupClass().getResource("HelloWorld.class"));
        Class.forName("com.lieve.agent.AgentMain", false, ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
