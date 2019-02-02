package com.lieve.base.javassist;

import java.lang.instrument.Instrumentation;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午4:58
 */
public class InstForTransformer {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("agentArgs : " + agentArgs);
        inst.addTransformer(new TestTransformer());
    }

}
