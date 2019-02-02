package com.lieve.base.asm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午12:46
 */
public class ASMTestMain {

    private final static DynamicClassLoader TEST_CLASS_LOADER =
        new DynamicClassLoader((URLClassLoader)ASMTestMain.class.getClassLoader());

    public static void main(String[] args) {

        try {
            /**
             * 修改前的Class
             */
            Class<?> beforeASMClass = TEST_CLASS_LOADER.loadClass("com.lieve.base.asm.ForASMTestClass");

            /**
             * 修改Class
             */
            TEST_CLASS_LOADER.defineClassByByteArray("com.lieve.base.asm.ForASMTestClass", asmChangeClassCall());

            /**
             * 修改后的Class
             */
            Class<?> afterASMClass =
                TEST_CLASS_LOADER.loadClass("com.lieve.base.asm.ForASMTestClass");

            Object beforeObject = beforeASMClass.newInstance();
            Object afterObject = afterASMClass.newInstance();
            beforeASMClass.getMethod("display1").invoke(beforeObject);
            afterASMClass.getMethod("display1").invoke(afterObject);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static byte[] asmChangeClassCall() {
        ClassReader classReader
            = null;
        try {
            classReader = new ClassReader("com.lieve.base.asm.ForASMTestClass");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ASMClassModifyAdpter modifyAdpter = new ASMClassModifyAdpter(classWriter);
        classReader.accept(modifyAdpter, ClassReader.SKIP_DEBUG);

        byte[] bytes = classWriter.toByteArray();
        try {
            File file = new File("/Users/sunlj/work/10-fengkong/modules/module-common/target/classes/com/lieve/ForASMTestClass.class");
            new FileOutputStream(file).write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
