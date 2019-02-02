### 1. 类中static 代码块、static 变量、final static 变量、普通代码块、对象构造方法的执行顺序？
    (1) static 变量的赋值操作会被放在static 代码块中执行
    (2) final static 普通变量（如int 或常量池中的String，即直接常量赋值，不是new String()），会直接赋值；
        如果是对象则依然编译到static块中执行，由<clinit>保证线程安全。
    (3) 普通代码块（非static代码块）被编译到相应类的gauze方法自定义语句的前面，在调用super() 操作的后面
    
