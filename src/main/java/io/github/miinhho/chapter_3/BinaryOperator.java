package io.github.miinhho.chapter_3;

import java.util.function.BiFunction;

interface BinaryOperator<T> extends BiFunction<T, T, T> {
    // ...
}