package io.github.miinhho.chapter_5.record_inheritence;

public record Rectangle(
        int x,
        int y,
        int width,
        int height) implements Origin, Area {
    @Override
    public float area() {
        return (float) (width() * height());
    }
}
