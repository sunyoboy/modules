package com.lieve.base.javassist;

import java.io.IOException;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午4:24
 */
public class JavassistTest {

    public static void main(String[] args) {
        try {
            CtClass ctClass = ClassPool.getDefault().get("com.lieve.base.Task");
            CtMethod ctMethod = ctClass.getDeclaredMethod("isTask");
            // System.out.println("打印我吧，求求你了！");
            ctMethod.insertBefore("System.out.println(\"打印我吧，求求你了！\");");

            // String a = "XXX 来了，快跑！";
            // System.out.println("我勒个去！");
            ctMethod.insertAfter("String a = \"XXX 来了，快跑！\";\n"
                + "System.out.println(\"我勒个去！\");");
            byte[] bytes = ctClass.toBytecode();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
