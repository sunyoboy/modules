package com.lieve.base.asm;

import java.net.URLClassLoader;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午12:39
 */
public class DynamicClassLoader extends URLClassLoader {

    public DynamicClassLoader(URLClassLoader parentClassLoader) {
        super(parentClassLoader.getURLs(), parentClassLoader);
    }

    public Class<?> defineClassByByteArray(String className, byte[] bytes) {
        // defineClass 对于同名的类如果调用两次以上就会报错
        return this.defineClass(className, bytes, 0, bytes.length);
    }

}
