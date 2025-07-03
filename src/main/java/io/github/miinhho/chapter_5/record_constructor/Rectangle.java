package io.github.miinhho.chapter_5.record_constructor;

public record Rectangle(Origin origin, int width, int height) {
    public Rectangle(int x, int y, int width, int height) {
        this(new Origin(x, y), width, height);
    }

    public Rectangle(int width, int height) {
        this(new Origin(), width, height);
    }

    public static Rectangle atX(int x, int width, int height) {
        return new Rectangle(x, 0, width, height);
    }

    public static Rectangle atY(int y, int width, int height) {
        return new Rectangle(0, y, width, height);
    }
}
