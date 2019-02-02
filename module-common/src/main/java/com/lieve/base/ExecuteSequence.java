package com.lieve.base;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @version 1.0
 * @since 2019/2/2 上午11:26
 */
public class ExecuteSequence {

    private static String staticVar = "staticVar";
    private static String staticNewVar = new String("staticNewVar");
    private final static String finalStaticVar = "finalStaticVar";

    static {
        String staticBlockVar = "staticBlockVar";
        String staticBlockNewVar = new String("staticBlockNewVar");
    }

    private String str = "str";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        System.out.println("exec sequence");
    }
}
