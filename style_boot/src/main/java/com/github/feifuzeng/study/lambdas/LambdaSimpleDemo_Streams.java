package com.github.feifuzeng.study.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


/**
 * @author feifz
 * @version 1.0.0
 * @Description 学习Lambda 使用Lambdas和Streams
 * @origin https://www.cnblogs.com/franson-2016/p/5593080.html
 * @Date 2018/12/24 16:49
 */
public class LambdaSimpleDemo_Streams {

    public static void main(String[] args) {
        streamDemo();
    }

    private static void streamDemo() {

        /**
         * 数据准备
         */
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Ffff", "f", "Java programmer", "female", 27, 1900));
                add(new Person("Aaaa", "a", "Java programmer", "male", 43, 2000));
                add(new Person("Hhhh", "h", "Java programmer", "female", 35, 1700));
                add(new Person("Llll", "l", "Java programmer", "female", 34, 1300));
                add(new Person("Bbbb", "b", "Java programmer", "female", 23, 1500));
                add(new Person("Cccc", "c", "Java programmer", "male", 33, 1800));
                add(new Person("Eeee", "e", "Java programmer", "male", 22, 1200));
                add(new Person("Dddd", "d", "Java programmer", "female", 32, 1600));
                add(new Person("Kkkk", "k", "Java programmer", "male", 33, 2000));
                add(new Person("Gggg", "g", "Java programmer", "male", 30, 2300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Pppp", "p", "PHP programmer", "male", 32, 1600));
                add(new Person("Mmmm", "m", "PHP programmer", "male", 34, 1550));
                add(new Person("Nnnn", "n", "PHP programmer", "female", 23, 1200));
                add(new Person("Rrrr", "r", "PHP programmer", "male", 32, 1100));
                add(new Person("Uuuu", "u", "PHP programmer", "male", 36, 1100));
                add(new Person("Qqqq", "q", "PHP programmer", "female", 21, 1000));
                add(new Person("Vvvv", "v", "PHP programmer", "female", 21, 1000));
                add(new Person("Tttt", "t", "PHP programmer", "female", 25, 1300));
                add(new Person("Wwww", "w", "PHP programmer", "male", 38, 1600));
                add(new Person("Yyyy", "y", "PHP programmer", "female", 40, 1800));
                add(new Person("Wwww", "w", "PHP programmer", "male", 38, 1600));
            }
        };

        /**
         * 1.现在我们使用forEach方法来迭代输出上述列表:
         */
        System.out.println("\nforEach方法来迭代输出上述列表-->所有程序员的姓名--->\n");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        /**
         * 2.用forEach方法,增加程序员的工资5%:
         */
        System.out.println("\n使用forEach方法,增加java程序员的工资5%-->\n");
        javaProgrammers.forEach((p) -> System.out.printf(" %s; ", p.getSalary()));
        System.out.println("\n");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);
        System.out.println("\njava程序员-->\n");
        javaProgrammers.forEach((p) -> System.out.printf(" %s; ", p.getSalary()));

        /**
         * 3.过滤器filter() ,让我们显示月薪超过1400美元的PHP程序员:
         */
        System.out.println("\n下面是月薪超过 $1,400 的PHP程序员-->\n");
        phpProgrammers.stream()
                .filter((p) -> (p.getSalary() > 1400))
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        /**
         * 4.定义过滤器,然后重用它们来执行其他操作
         */
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

        System.out.println("\n下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员-->\n");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        // 重用filters
        System.out.println("\n年龄大于 24岁的女性 Java programmers:\n");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        /**
         * 5.使用limit方法,可以限制结果集的个数:
         */
        System.out.println("\n最前面的3个 Java programmers:\n");
        javaProgrammers.stream()
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

//风雨十年，同舟百年，我们在西安祝北京公司十周年生日快乐，创新不止，再创辉煌。
        System.out.println("\n最前面的3个女性 Java programmers:\n");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        /**
         * 6.排序呢? 我们在stream中能处理吗? 答案是肯定的。 在下面的例子中,我们将根据名字和薪水排序Java程序员,放到一个list中,然后显示列表:
         */
        System.out.println("\n根据 name 排序,并显示前5个 Java programmers:\n");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        System.out.println("\n根据 salary 排序 Java programmers:\n");
        sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        /**
         * 7.如果我们只对最低和最高的薪水感兴趣,比排序后选择第一个/最后一个 更快的是min和max方法:
         */
        System.out.println("\n工资最低的 Java programmer:\n");
        Person pers = javaProgrammers
                .stream()
                .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());

        System.out.println("\n工资最高的 Java programmer:\n");
        Person person = javaProgrammers
                .stream()
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());

        /**
         * 8.结合 map 方法,我们可以使用 collect 方法来将我们的结果集放到一个字符串,一个 Set 或一个TreeSet中:
         */
        System.out.println("\n将 PHP programmers 的 first name 拼接成字符串:\n");
        String phpDevelopers = phpProgrammers
                .stream()
                .map(Person::getFirstName)
                /**
                 * // 在进一步的操作中可以作为标记(token)
                 */
                .collect(joining(" ; "));

        System.out.println("\n将 Java programmers 的 first name 存放到 Set:\n");
        Set<String> javaDevFirstName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(toSet());

        System.out.println("将 Java programmers 的 first name 存放到 TreeSet:");
        TreeSet<String> javaDevLastName = javaProgrammers
                .stream()
                .map(Person::getLastName)
                .collect(toCollection(TreeSet::new));

        /**
         * 9.Streams 还可以是并行的(parallel)。 示例如下:
         */
        System.out.println("计算付给 Java programmers 的所有money:");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();
        System.out.println(totalSalary);

        /**
         * 10.我们可以使用summaryStatistics方法获得stream 中元素的各种汇总数据。 接下来,我们可以访问这些方法,比如getMax, getMin, getSum或getAverage:
         */
        //计算 count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 21, 3, 44, 5, 6, 77, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }
}
