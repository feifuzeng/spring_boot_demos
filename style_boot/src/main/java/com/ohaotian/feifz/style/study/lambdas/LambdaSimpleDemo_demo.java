package com.ohaotian.feifz.style.study.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feifz
 * @version 1.0.0
 * @Description lambda示例类
 * @createTime 2019年04月16日 14:10:00
 */
public class LambdaSimpleDemo_demo {

    public static void main(String[] args) {
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

        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setPeople(phpProgrammers);

        user.getPeople().stream().forEach(person -> {person.setFirstName(null);});
        user.getPeople().forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }
}
