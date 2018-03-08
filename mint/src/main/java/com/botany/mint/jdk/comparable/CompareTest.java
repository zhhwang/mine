package com.botany.mint.jdk.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangzh
 */
public class CompareTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jack", 42));
        personList.add(new Person("Sya", 22));

        // 年龄升序
        personList.sort(new PersonComparator());
        // or
        personList.sort(Comparator.comparing(Person::getAge));
        // or
        personList.sort(Comparator.comparingInt(Person::getAge));
        // or
        Collections.sort(personList, Comparator.comparing(Person::getAge));


        // PersonComparable 实现了comparable, 使两个PersonComparable可以直接比较
        List<Woman> womanList = new ArrayList<>();
        womanList.add(new Woman("apple", new PersonComparable("Jack", 42)));
        womanList.add(new Woman("banana", new PersonComparable("Sya", 22)));
        womanList.sort(Comparator.comparing(Woman::getPersonComparable));
    }
}
