package com.lieve.base;

import java.io.Serializable;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 下午3:03
 */
public abstract class ChildClass implements Serializable {

    public static final int zero = 0;

    public abstract int compareTo(Object o);
}
