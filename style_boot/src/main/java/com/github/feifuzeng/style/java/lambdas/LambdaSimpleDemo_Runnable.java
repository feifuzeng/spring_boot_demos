package com.github.feifuzeng.style.java.lambdas;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 学习Lambda 简单示例-runnable
 * @Date 2018/12/25 17:24
 */
public class LambdaSimpleDemo_Runnable {

    public static void main(String[] args) {
        runnableDemo();
    }

    private static void runnableDemo() {
        /**
         * 1.1使用匿名内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1.1使用匿名内部类-->Hello world !");
            }
        }).start();

        /**
         * 1.2使用 lambda expression
         */
        new Thread(() -> System.out.println("1.2使用 lambda expression-->Hello world !")).start();

        /**
         * 2.1使用匿名内部类
         */
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("2.1使用匿名内部类-->Hello world !");
            }
        };

        /**
         * 2.2使用 lambda expression
         */
        Runnable race2 = () -> System.out.println("2.2使用 lambda expression-->Hello world !");

        /**
         * 直接调用 run 方法(没开新线程哦!)
         */
        race1.run();
        race2.run();
    }
}
