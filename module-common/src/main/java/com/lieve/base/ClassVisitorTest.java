package com.lieve.base;

import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午2:52
 */
public class ClassVisitorTest {

    public static void main(String[] args) {
        try {
            ClassReader classReader = new ClassReader("com.lieve.base.Task");
            ClassPrintClassVisitor classVisitor = new ClassPrintClassVisitor();
            classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
            gen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] gen() {
        ClassWriter classWriter  = new ClassWriter(COMPUTE_MAXS);
        classWriter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT,
            "com/lieve/base/ChildClass", null, "java/lang/Object",
            new String[]{"java/io/Serializable"});
        classWriter
            .visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + ACC_STATIC, "zero", "I", null, new Integer(0))
            .visitEnd();
        classWriter
            .visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
            .visitEnd();
        classWriter.visitEnd();
        byte[] bytes = classWriter.toByteArray();
        try {
            System.out.println(MethodHandles.lookup().lookupClass().getResource("").getPath());
            new FileOutputStream(MethodHandles.lookup().lookupClass()
                .getResource("").getPath() + "ChildClass2.class").write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
