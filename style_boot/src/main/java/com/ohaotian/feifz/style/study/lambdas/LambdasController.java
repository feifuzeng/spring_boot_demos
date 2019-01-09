package com.ohaotian.feifz.style.study.lambdas;//package com.ohaotian.feifz.demo.lambdas;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
///**
// * @author feifz
// * @version 1.0.0
// * @Description TOOD
// * @Date 2018/12/24 16:02
// */
//public class LambdasController {
//
//    public static void main(String[] args) {
//        sortDemo();
//    }
//
//
//    /**
//     * lambdas 来实现简单的循环 的示例
//     */
//    public static void forEachDemo() {
//        String[] atp = {"Rafael Nadal", "Novak Djokovic",
//                "Stanislas Wawrinka",
//                "David Ferrer", "Roger Federer",
//                "Andy Murray", "Tomas Berdych",
//                "Juan Martin Del Potro"};
//        List<String> players = Arrays.asList(atp);
//
//        /**
//         * 以前的循环方式
//         */
//        System.out.println("\n以前的循环方式--->\n");
//        for (String player : players) {
//            System.out.print(player + "; ");
//        }
//
//        /**
//         * 使用 lambda 表达式以及函数操作(functional operation)
//         */
//        System.out.println("\n使用 lambda 表达式以及函数操作--->\n");
//        players.forEach((player) -> System.out.print(player + "; "));
//
//        /**
//         * 在 Java 8 中使用双冒号操作符(double colon operator)
//         */
//        System.out.println("\n在 Java 8 中使用双冒号操作符--->\n");
//        players.forEach(System.out::println);
//    }
//
//    /**
//     * lambdas 来实现 Runnable接口 的示例
//     */
//    public static void runable() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello world !");
//            }
//        }).start();
//        // 1.2使用 lambda expression
//        new Thread(() -> System.out.println("Hello world !")).start();
//
//        // 2.1使用匿名内部类
//        Runnable race1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello world !");
//            }
//        };
//        // 2.2使用 lambda expression
//        Runnable race2 = () -> System.out.println("Hello world !");
//        // 直接调用 run 方法(没开新线程哦!)
//        race1.run();
//        race2.run();
//    }
//
//    /**
//     * 传统方式&Lambda表达式---集合排序
//     */
//    public static void sortDemo() {
//        String[] players = {"Rafael Nadal", "Novak Djokovic",
//                "Stanislas Wawrinka", "David Ferrer",
//                "Roger Federer", "Andy Murray",
//                "Tomas Berdych", "Juan Martin Del Potro",
//                "Richard Gasquet", "John Isner"};
//        List<String> playerList = Arrays.asList(players);
////        排序前
//
//        System.out.println("---------------排序前-----------------------------------------------------------------------------------");
//        playerList.forEach((player) -> {
//            System.out.println(player);
//        });
//        /**
//         * 1.1 使用匿名内部类根据 name 排序 players
//         */
//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return (s1.compareTo(s2));
//            }
//        });
//
//        /**
//         * 1.2 使用 lambda expression 排序 players
//         */
//        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
//        Arrays.sort(players, sortByName);
//        System.out.println("---------------排序后-----------------------------------------------------------------------------------");
//        playerList.forEach((player) -> {
//            System.out.println(player);
//        });
//
//        /**
//         * 1.3 也可以采用如下形式:
//         */
//        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
//        System.out.println("---------------1.3 排序后-----------------------------------------------------------------------------------");
//        playerList.forEach((player) -> {
//            System.out.println(player);
//        });
//    }
//}
