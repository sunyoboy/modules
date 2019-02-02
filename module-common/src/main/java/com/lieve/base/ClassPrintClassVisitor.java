package com.lieve.base;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午2:46
 */
public class ClassPrintClassVisitor implements ClassVisitor {

    public ClassPrintClassVisitor() {

    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName,
        String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }

    @Override
    public void visitSource(String source, String debug) {

    }

    @Override
    public void visitOuterClass(String owner, String name, String desc) {

    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }

    @Override
    public void visitAttribute(Attribute attr) {

    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {

    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature,
        Object value) {
        if (name.startsWith("is")) {
            System.out.println("    field name: " + name + " desc: " + desc);
        } else {
            System.out.println("    field name: " + name + " desc: " + desc);
        }
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature,
        String[] exceptions) {
        if (name.startsWith("is")) {
            System.out.println("    start with is method: " + name + " desc: " + desc);
        } else {
            System.out.println("    start with is method: " + name + " desc: " + desc);
        }
        return null;
    }

    @Override
    public void visitEnd() {
        System.out.println("}");
    }
}
