package com.lieve.agent;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.generic.ClassGen;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/2/1 下午9:31
 */


public class AgentMain2 {

    public static void premain(String arg, Instrumentation  instrumentation) {
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className,
                Class<?> classBeingRedefined,
                ProtectionDomain protectionDomain, byte[] classfileBuffer)
                throws IllegalClassFormatException {
                if (!className.equals(arg)) {
                    return null;
                }

                ClassParser classParser = new ClassParser(new ByteArrayInputStream(classfileBuffer),
                    className + ".class");
                try {
                    JavaClass javaClass = classParser.parse();
                    ClassGen classGen = new ClassGen(javaClass);
                    /*EntryLogger entryLogger = new EntryLogger(classGen);
                    entryLogger.convert();*/
                    return classGen.getJavaClass().getBytes();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // return new byte[0];
                return null;
            }
        });
    }
}
