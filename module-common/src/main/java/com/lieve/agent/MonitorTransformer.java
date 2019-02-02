package com.lieve.agent;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/2/1 下午5:12
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MonitorTransformer implements ClassFileTransformer {

    public static final String transClassNameReturn2 = "/Users/sunlj/work/10-fengkong/modules/module-common/target/classes/com/lieve/agent/TransClass.class.2";

    public static byte[] getBytesFromFile(String fileName) {

        System.out.println("getBytesFromFile " + fileName);
        /**
         * precondition
         */
        File file = new File(fileName);
        try {
            InputStream  inputStream = new FileInputStream(file);
            long length  = file.length();
            byte[] bytes = new byte[(int) length];

            /**
             * read in bytes
             *
             */
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("could not complete read file" + fileName);
            }
            inputStream.close();
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
        ProtectionDomain protectionDomain, byte[] classfileBuffer)
        throws IllegalClassFormatException {
        System.out.println("className : " + className);
        if (!className.contains("TransClass"))  {
            return null;
        }

        return getBytesFromFile(transClassNameReturn2);
    }
}
