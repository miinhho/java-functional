package io.github.miinhho.chapter_5.record_inheritence;

public interface Origin {
    int x();

    int y();

    default String origin() {
        return String.format("(%d/%d)", x(), y());
    }
}
