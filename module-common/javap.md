ExecuteSequence.java 类文件内容:
    
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



javap 反编译结果：
    
    └[~/work/10-fengkong/modules/module-common/target/classes]> javap -verbose com.lieve.base.ExecuteSequence
    Classfile /Users/sunlj/work/10-fengkong/modules/module-common/target/classes/com/lieve/base/ExecuteSequence.class
      Last modified Feb 2, 2019; size 1126 bytes
      MD5 checksum 9755ed39d5bd210b40b3af19de6ea21b
      Compiled from "ExecuteSequence.java"
    public class com.lieve.base.ExecuteSequence
      minor version: 0
      major version: 52
      flags: ACC_PUBLIC, ACC_SUPER
    Constant pool:
       #1 = Methodref          #16.#43        // java/lang/Object."<init>":()V
       #2 = String             #23            // str
       #3 = Fieldref           #15.#44        // com/lieve/base/ExecuteSequence.str:Ljava/lang/String;
       #4 = Fieldref           #45.#46        // java/lang/System.out:Ljava/io/PrintStream;
       #5 = String             #47            // exec sequence
       #6 = Methodref          #48.#49        // java/io/PrintStream.println:(Ljava/lang/String;)V
       #7 = String             #17            // staticVar
       #8 = Fieldref           #15.#50        // com/lieve/base/ExecuteSequence.staticVar:Ljava/lang/String;
       #9 = Class              #51            // java/lang/String
      #10 = String             #19            // staticNewVar
      #11 = Methodref          #9.#52         // java/lang/String."<init>":(Ljava/lang/String;)V
      #12 = Fieldref           #15.#53        // com/lieve/base/ExecuteSequence.staticNewVar:Ljava/lang/String;
      #13 = String             #40            // staticBlockVar
      #14 = String             #54            // staticBlockNewVar
      #15 = Class              #55            // com/lieve/base/ExecuteSequence
      #16 = Class              #56            // java/lang/Object
      #17 = Utf8               staticVar
      #18 = Utf8               Ljava/lang/String;
      #19 = Utf8               staticNewVar
      #20 = Utf8               finalStaticVar
      #21 = Utf8               ConstantValue
      #22 = String             #20            // finalStaticVar
      #23 = Utf8               str
      #24 = Utf8               <init>
      #25 = Utf8               ()V
      #26 = Utf8               Code
      #27 = Utf8               LineNumberTable
      #28 = Utf8               LocalVariableTable
      #29 = Utf8               this
      #30 = Utf8               Lcom/lieve/base/ExecuteSequence;
      #31 = Utf8               getStr
      #32 = Utf8               ()Ljava/lang/String;
      #33 = Utf8               setStr
      #34 = Utf8               (Ljava/lang/String;)V
      #35 = Utf8               main
      #36 = Utf8               ([Ljava/lang/String;)V
      #37 = Utf8               args
      #38 = Utf8               [Ljava/lang/String;
      #39 = Utf8               <clinit>
      #40 = Utf8               staticBlockVar
      #41 = Utf8               SourceFile
      #42 = Utf8               ExecuteSequence.java
      #43 = NameAndType        #24:#25        // "<init>":()V
      #44 = NameAndType        #23:#18        // str:Ljava/lang/String;
      #45 = Class              #57            // java/lang/System
      #46 = NameAndType        #58:#59        // out:Ljava/io/PrintStream;
      #47 = Utf8               exec sequence
      #48 = Class              #60            // java/io/PrintStream
      #49 = NameAndType        #61:#34        // println:(Ljava/lang/String;)V
      #50 = NameAndType        #17:#18        // staticVar:Ljava/lang/String;
      #51 = Utf8               java/lang/String
      #52 = NameAndType        #24:#34        // "<init>":(Ljava/lang/String;)V
      #53 = NameAndType        #19:#18        // staticNewVar:Ljava/lang/String;
      #54 = Utf8               staticBlockNewVar
      #55 = Utf8               com/lieve/base/ExecuteSequence
      #56 = Utf8               java/lang/Object
      #57 = Utf8               java/lang/System
      #58 = Utf8               out
      #59 = Utf8               Ljava/io/PrintStream;
      #60 = Utf8               java/io/PrintStream
      #61 = Utf8               println
    {
      public com.lieve.base.ExecuteSequence();
        descriptor: ()V
        flags: ACC_PUBLIC
        Code:
          stack=2, locals=1, args_size=1
             0: aload_0
             1: invokespecial #1                  // Method java/lang/Object."<init>":()V
             4: aload_0
             5: ldc           #2                  // String str
             7: putfield      #3                  // Field str:Ljava/lang/String;
            10: return
          LineNumberTable:
            line 8: 0
            line 19: 4
          LocalVariableTable:
            Start  Length  Slot  Name   Signature
                0      11     0  this   Lcom/lieve/base/ExecuteSequence;
    
      public java.lang.String getStr();
        descriptor: ()Ljava/lang/String;
        flags: ACC_PUBLIC
        Code:
          stack=1, locals=1, args_size=1
             0: aload_0
             1: getfield      #3                  // Field str:Ljava/lang/String;
             4: areturn
          LineNumberTable:
            line 22: 0
          LocalVariableTable:
            Start  Length  Slot  Name   Signature
                0       5     0  this   Lcom/lieve/base/ExecuteSequence;
    
      public void setStr(java.lang.String);
        descriptor: (Ljava/lang/String;)V
        flags: ACC_PUBLIC
        Code:
          stack=2, locals=2, args_size=2
             0: aload_0
             1: aload_1
             2: putfield      #3                  // Field str:Ljava/lang/String;
             5: return
          LineNumberTable:
            line 26: 0
            line 27: 5
          LocalVariableTable:
            Start  Length  Slot  Name   Signature
                0       6     0  this   Lcom/lieve/base/ExecuteSequence;
                0       6     1   str   Ljava/lang/String;
    
      public static void main(java.lang.String[]);
        descriptor: ([Ljava/lang/String;)V
        flags: ACC_PUBLIC, ACC_STATIC
        Code:
          stack=2, locals=1, args_size=1
             0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
             3: ldc           #5                  // String exec sequence
             5: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
             8: return
          LineNumberTable:
            line 30: 0
            line 31: 8
          LocalVariableTable:
            Start  Length  Slot  Name   Signature
                0       9     0  args   [Ljava/lang/String;
    
      static {};
        descriptor: ()V
        flags: ACC_STATIC
        Code:
          stack=3, locals=2, args_size=0
             0: ldc           #7                  // String staticVar
             2: putstatic     #8                  // Field staticVar:Ljava/lang/String;
             5: new           #9                  // class java/lang/String
             8: dup
             9: ldc           #10                 // String staticNewVar
            11: invokespecial #11                 // Method java/lang/String."<init>":(Ljava/lang/String;)V
            14: putstatic     #12                 // Field staticNewVar:Ljava/lang/String;
            17: ldc           #13                 // String staticBlockVar
            19: astore_0
            20: new           #9                  // class java/lang/String
            23: dup
            24: ldc           #14                 // String staticBlockNewVar
            26: invokespecial #11                 // Method java/lang/String."<init>":(Ljava/lang/String;)V
            29: astore_1
            30: return
          LineNumberTable:
            line 10: 0
            line 11: 5
            line 15: 17
            line 16: 20
            line 17: 30
          LocalVariableTable:
            Start  Length  Slot  Name   Signature
               20      10     0 staticBlockVar   Ljava/lang/String;
    }
    SourceFile: "ExecuteSequence.java"


"常量池"（Constant pool）每一项都以"#数字"开头
