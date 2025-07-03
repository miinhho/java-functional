package io.github.miinhho.chapter_5.record_inheritence;

public record Circle(int x, int y, int radius) implements Origin, Area {
    @Override
    public float area() {
        return (float) Math.PI * radius() * radius();
    }
}
