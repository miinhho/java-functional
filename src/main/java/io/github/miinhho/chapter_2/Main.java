package io.github.miinhho.chapter_2;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Main {
    static Map<String, Object> cache = new HashMap<>();

    public static void main(String[] args) {
        basicLambda();
        capture();
        refinalize();
        anonymousClassAndLamdba();
        creatingLambda();
        callingLambda();
        methodReference();
        constructorReference();
        caching();
    }

    static void basicLambda() {
        Function<Integer, Integer> quadratic = value -> value * value;
        Function<Integer, Integer> quadraticWithBlock = value -> {
            return value * value;
        };
    }

    static void capture() {
        var theAnswer = 42;
        Runnable printAnswer = () -> System.out.println("the answer is " + theAnswer);
        run(printAnswer);
    }

    static void run(Runnable r) {
        r.run();
    }

    static void refinalize() {
        // 이때는 effectively final
        var nonEffectivelyFinal = 1_000L;
        // 변수를 변경하였기 때문에 더이상 effectivelt final 이 아님
        nonEffectivelyFinal = 9_000L;
        // 새 변수를 선언하고 변경하지 않으면 다시 참조를 final 로 만드는 효과를 가짐
        var finalAgain = nonEffectivelyFinal;
        Predicate<Long> isOver9000 = input -> input > finalAgain;
    }

    static void anonymousClassAndLamdba() {
        var helloWorld = new HelloWorld() {
            @Override
            public String sayHello(String name) {
                return "hello, " + name + "|";
            }
        };

        HelloWorld helloWorldLamdba = name -> "hello, " + name + "|";
    }

    static void creatingLambda() {
        Predicate<String> isNull = value -> value == null;
    }

    static void callingLambda() {
        Function<String, String> helloWorld = name -> "hello, " + name + "|";
        var result = helloWorld.apply("Ben");
    }

    static void methodReference() {
        new SubClass().superAndThis("hello, World!");

        Function<String, String> toLowerCaseLamdba = str -> str.toLowerCase();
        Function<String, String> toLowerCaseRef = String::toLowerCase;
    }

    @SuppressWarnings("deprecation")
    static void constructorReference() {
        Function<String, Locale> newLocaleLamdba = language -> new Locale(language);
        Function<String, Locale> newLocaleRef = Locale::new;
    }

    @SuppressWarnings("unchecked")
    static <T> T memoize(String identifier, Supplier<T> fn) {
        return (T) cache.computeIfAbsent(identifier, key -> fn.get());
    }

    static Integer expensiveCall(String arg, int arg1) {
        return arg1;
    }

    static Integer memoizedCall(String arg, int arg1) {
        var compoundKey = String.format("expensiveCall:%s-%d", arg, arg1);
        return memoize(compoundKey, () -> expensiveCall(arg, arg1));
    }

    static void caching() {
        var calculated = memoizedCall("hello, world!", 42);
        var cached = memoizedCall("hello, world!", 42);
    }
}