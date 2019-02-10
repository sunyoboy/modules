package com.lieve.base.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/6 下午6:34
 */
public class AnnotationProcessor {

    public static void processAnnotations(Object obj) {
        Class<?> cl = obj.getClass();
        for (Method m : cl.getDeclaredMethods()) {
            MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);

            if (myAnnotation != null) {
                try {
                    Field f = cl.getDeclaredField(myAnnotation.source());
                    f.setAccessible(true);
                    handleAnnotationMethod(f.get(obj), obj, m);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void handleAnnotationMethod(Object source,
        final Object param, final Method method) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(param);
            }
        };
    }

}
