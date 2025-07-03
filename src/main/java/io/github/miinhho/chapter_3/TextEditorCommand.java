package io.github.miinhho.chapter_3;

import java.util.function.Supplier;

public interface TextEditorCommand extends Supplier<String> {
    String execute();

    default String get() {
        return execute();
    }
}
