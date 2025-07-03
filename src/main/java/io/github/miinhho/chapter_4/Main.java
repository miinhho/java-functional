package io.github.miinhho.chapter_4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        immutableMath();
        finalReference();
    }

    static void immutableMath() {
        var theAnswer = new BigDecimal(42);
        var result = theAnswer.add(BigDecimal.ONE);

        System.out.println(result);
        System.out.println(theAnswer);
    }

    static void finalReference() {
        final List<String> fruits = new ArrayList<>();

        System.out.println(fruits.isEmpty());

        fruits.add("Apple");
        System.out.println(fruits.isEmpty());
    }
}
