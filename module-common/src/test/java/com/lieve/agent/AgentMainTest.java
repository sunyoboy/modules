package com.lieve.agent;

import java.lang.invoke.MethodHandles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* AgentMain Tester.
*
* @author sunlijiang
* @since <pre>二月 1, 2019</pre>
* @version 1.0
*/
public class AgentMainTest {

    private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

        /**
    *
    * Method: premain(String args, Instrumentation instrumentation)
    *
    */
    @Test
    public void testPremain() throws Exception {
    //TODO: Test goes here...
    }

        /**
    *
    * Method: agentmain(String args, Instrumentation instrumentation)
    *
    */
    @Test
    public void testAgentmain() throws Exception {
    //TODO: Test goes here...
    }

    public static void main(String[] args) {
        sayHello();
        sayWorld("world!");
        System.out.println(new TransClass().getNumber());
    }

    public static void sayHello() {
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
            System.out.println("hello!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("this method cost : " + (endTime - startTime) +  "ms.");
    }

    public static void sayWorld(String world) {
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
            System.out.println(world);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("this method cost : " + (endTime - startTime) +  "ms.");
    }

    }
