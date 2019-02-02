使用-javaagent:<jarpath>[=<选项>]
                    加载 Java 编程语言代理, 请参阅 java.lang.instrument
eg 1: 

    java  -javaagent:/Users/sunlj/work/10-fengkong/modules/module-common/target/lieve-agent.jar \
        com.lieve.agent.TestInstrumentation 

增加选项:
    -XX:+TraceClassLoading

eg 2 :

    java -XX:+TraceClassLoading -javaagent:/Users/sunlj/work/10-fengkong/modules/module-common/target/lieve-agent.jar \
        com.lieve.agent.TestInstrumentation 
