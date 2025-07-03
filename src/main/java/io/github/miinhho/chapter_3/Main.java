package io.github.miinhho.chapter_3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = str -> str != null ? str.length() : 0;
        Integer funtionResult = stringLength.apply("Hello, Function!");

        Consumer<String> println = str -> System.out.println(str);
        println.accept("Hello, Consumer!");

        Supplier<Double> random = () -> Math.random();
        Double supplierResult = random.get();

        Predicate<Integer> over9000 = i -> i > 9000;
        boolean predicateResult = over9000.test(12_345);
    }

    void functionalComposition() {
        Function<String, String> removeLowerCaseA = str -> str.replace("a", "");
        Function<String, String> upperCase = String::toUpperCase;

        var input = "abcd";

        removeLowerCaseA.andThen(upperCase)
                .apply(input);

        upperCase.compose(removeLowerCaseA)
                .apply(input);
    }

    void functionalCompositor() {
        Function<String, String> removeLowerCaseA = str -> str.replace("a", "");
        Function<String, String> upperCase = String::toUpperCase;

        Function<String, String> stringOperations = removeLowerCaseA.andThen(upperCase);

        Consumer<String> task = Compositor.compose(stringOperations, System.out::println);
        task.accept("abcd");
    }
}
