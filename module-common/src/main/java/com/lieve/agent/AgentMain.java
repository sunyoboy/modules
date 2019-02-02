package com.lieve.agent;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/2/1 下午4:41
 */

import java.lang.instrument.Instrumentation;

public class AgentMain {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("premain " + args);
        instrumentation.addTransformer(new MonitorTransformer());
    }

    public static void agentmain(String args, Instrumentation instrumentation) {
        System.out.println("agentmain " + args);
        instrumentation.addTransformer(new MonitorTransformer());
    }

}
