package io.github.miinhho.chapter_2;

import java.util.function.Function;

public class SubClass extends SuperClass {
    @Override
    public String doWork(String input) {
        return "this: " + input;
    }

    public void superAndThis(String input) {
        Function<String, String> thisWorker = this::doWork;
        var thisResult = thisWorker.apply(input);
        System.out.println(thisResult);

        Function<String, String> superWorker = SubClass.super::doWork;
        var superResult = superWorker.apply(input);
        System.out.println(superResult);
    }
}
