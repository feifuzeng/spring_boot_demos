package com.ohaotian.feifz.style.study.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 学习Lambda 简单示例-排序sort
 * @Date 2018/12/25 17:24
 */
public class LambdaSimpleDemo_Sort {

    public static void main(String[] args) {
        lambdaSortDemo();
    }

    private static void lambdaSortDemo() {
        String[] players = {"Rafael", "Novak", "Stanislas", "David", "Roger", "Andy", "Tomas", "Juan", "Richard", "John"};
        List<String> playersList = Arrays.asList(players);
        /**
         * 1.1 使用匿名内部类根据 name 排序 players
         */
        System.out.println("------------1.1 使用匿名内部类根据 name 排序 players---------------------------------------------------------------------------------------------------");
        System.out.println("排序前-->");
        playersList.forEach((player) -> System.out.println(player));
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        playersList = Arrays.asList(players);
        System.out.println("排序后-->");
        playersList.forEach((player) -> System.out.println(player));
        /**
         * 1.2 使用 lambda expression 排序 players
         */
        System.out.println("------------1.2 使用 lambda expression 排序 players--------------------------------------------------------------------------------------------------");
        players = new String[]{"Rafael", "Novak", "Stanislas", "David", "Roger", "Andy", "Tomas", "Juan", "Richard", "John"};
        playersList = Arrays.asList(players);
        System.out.println("排序前-->");
        playersList.forEach((player) -> System.out.println(player));
        //方式1
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        //方式2
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
        System.out.println("排序后-->");
        playersList.forEach((player) -> System.out.println(player));
    }
}
