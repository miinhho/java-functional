package io.github.miinhho.chapter_5.record_constructor;

public record Origin(int x, int y) {
    public static Origin ZERO = new Origin(0, 0);

    public Origin() {
        this(0, 0);
    }
}
