package com.github.feifuzeng.style.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 学习Lambda 简单示例-forEach循环
 * @Date 2018/12/25 17:08
 */
public class LambdaSimpleDemo_Foreach {

    public static void main(String[] args) {
        /**
         * lambdas 来实现简单的循环 的示例
         */
        forEachDemo();
    }

    /**
     * lambdas 来实现简单的循环 的示例
     */
    public static void forEachDemo() {
        String[] atp = {"Rafael", "Novak", "Stanislas", "David", "Roger", "Andy", "Tomas", "Juan"};
        List<String> players = Arrays.asList(atp);
        /**
         * 以前的循环方式
         */
        System.out.println("\n以前的循环方式--->\n");
        for (String player : players) {
            System.out.print(player + "; ");
        }
        /**
         * 使用 lambda 表达式以及函数操作(functional operation)
         */
        System.out.println("\n使用 lambda 表达式以及函数操作--->\n");
        players.forEach((player) -> System.out.print(player + "; "));
        /**
         * 在 Java 8 中使用双冒号操作符(double colon operator)
         */
        System.out.println("\n在 Java 8 中使用双冒号操作符--->\n");
        players.forEach(System.out::println);
    }
}
