package com.lieve.base;

import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

import java.io.IOException;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午3:55
 */
public class TraceClassVisitorTest {

    public static void main(String[] args) {
        ClassReader classReader = null;
        try {
            classReader = new ClassReader("com.lieve.base.Task");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClassWriter classWriter = new ClassWriter(COMPUTE_MAXS);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(classWriter, new PrintWriter(System.out));
        classReader.accept(traceClassVisitor, ClassReader.SKIP_DEBUG);
    }
}
