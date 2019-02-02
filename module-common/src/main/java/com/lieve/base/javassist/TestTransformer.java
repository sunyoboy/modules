package com.lieve.base.javassist;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午4:42
 */
public class TestTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
        ProtectionDomain protectionDomain, byte[] classfileBuffer)
        throws IllegalClassFormatException {
        System.out.println("load class: " + className);

        if ("com/lieve/base/asm/ForASMTestClass".equals(className)) {
            try {
                CtClass ctClass = ClassPool.getDefault().get(className.replace("/","."));
                CtMethod ctMethod = ctClass.getDeclaredMethod("display1");
                // System.out.println("打印我吧，求求你了！");
                ctMethod.insertBefore("value = \"我是value!\";"
                    + "name = \"我是name! 这次用的是javaassist!\";"
                    + "System.out.println(\"打印我吧，求求你了！\");");

                // String a = "XXX 来了，快跑！";
                // System.out.println("我勒个去！");
                ctMethod.insertAfter("String a = \"XXX 来了，快跑！\";\n"
                    + "System.out.println(a);"
                    + "System.out.println(\"我勒个去！\");");
                return ctClass.toBytecode();
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }
}
