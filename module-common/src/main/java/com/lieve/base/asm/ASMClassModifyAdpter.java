package com.lieve.base.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ASMClassModifyAdpter extends ClassAdapter {

    public ASMClassModifyAdpter(ClassVisitor classVisitor) {
        super(classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String methodName,
        final String desc, final String signature, final String[] exceptions) {
        if ("display2".equals(methodName)) {
            return null; //我们屏蔽了这个方法
        }
        if ("display1".equals(methodName)) {
            MethodVisitor methodVisitor = cv
                .visitMethod(access, methodName, desc, signature, exceptions);
            methodVisitor.visitCode();
            //增加的语句等价于增加代码：name = "我是name"
            // 加载this 到栈顶
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitLdcInsn("我是name");
            methodVisitor
                .visitFieldInsn(Opcodes.PUTFIELD, "com/lieve/base/asm/ForASMTestClass", "name",
                    "Ljava/lang/String;");

            // 这条语句等价于增加代码：value = "我是value";
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitLdcInsn("我是value");

            // putfield 指令，修改ForASMTestClass 的name 属性
            methodVisitor
                .visitFieldInsn(Opcodes.PUTFIELD, "com/lieve/base/asm/ForASMTestClass", "value",
                    "Ljava/lang/String;");

            //再将一个属性获取出来打印出来
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor
                .visitFieldInsn(Opcodes.GETFIELD, "com/lieve/base/asm/ForASMTestClass", "value",
                    "Ljava/lang/String;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V");

            //再将一个属性获取出来打印出来
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor
                .visitFieldInsn(Opcodes.GETFIELD, "com/lieve/base/asm/ForASMTestClass", "value",
                    "Ljava/lang/String;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V");
            System.out.println("end");
            methodVisitor.visitEnd();
            return methodVisitor;//返回visitor
        } else {
            return cv.visitMethod(access, methodName, desc, signature, exceptions);
        }
    }

}
