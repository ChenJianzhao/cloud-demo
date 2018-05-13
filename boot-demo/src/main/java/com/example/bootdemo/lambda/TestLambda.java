package com.example.bootdemo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestLambda {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(new Integer[]{1,2,3});
//        list.forEach(System.out::println);

//        testPredicate();

        testMap();
    }



    public static void testPredicate() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);
    }

    // stream 一次操作
//    public static void filter(List<String> names, Predicate<String> condition) {
//        for(String name: names)  {
//            if(condition.test(name)) {
//                System.out.println(name + " ");
//            }
//        }
//    }

    // 更好的办法，stream 连续操作
    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream()
//                .filter( name -> condition.test(name) )   // 普通方法
//                .filter(condition::test)                  // 使用 Predicate.test() 作为方法
                .filter(condition)                          // 直接使用 Predicate
                .forEach(System.out::println);
    }

    /**
     * 多个 Predicate 操作
     * @param names
     * @param condition1
     * @param condition2
     */
    public static void multiFilter(List<String> names, Predicate<String> condition1, Predicate<String> condition2) {
        names.stream()
                .filter(condition1.and(condition2))
                .forEach(System.out::println);
    }

    public static void testMap() {
        // 新方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map( cost ->  cost + 0.12 * cost ).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }

    public static void te() {
        List<String> filtered =  Arrays.asList(new String[]{"adf","fhghgfd"}).stream().filter(x -> x.length()> 2).collect(Collectors.toList());
//        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
}
