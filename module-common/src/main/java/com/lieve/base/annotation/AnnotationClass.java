package com.lieve.base.annotation;

import org.springframework.transaction.annotation.Transactional;
/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/6 下午6:05
 */
@MyAnnotation(source = "src")
public class AnnotationClass {

    private String src;

    public static void main(String[] args) {
        System.out.println(AnnotationClass.class);
        // AnnotationProcessor.processAnnotations(new AnnotationClass());
        System.out.println(AnnotationClass.class.isAnnotation());
        System.out.println(MyAnnotation.class.isAnnotation());
        System.out.println(AnnotationClass.class.getAnnotations());
        System.out.println(AnnotationClass.class.isAnnotationPresent(MyAnnotation.class));
    }

    @Transactional
    @MyAnnotation(source = "src")
    public void action() {

    }
}
