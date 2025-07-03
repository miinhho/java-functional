package io.github.miinhho.chapter_5.wither;

public record Point(int x, int y) {
    public With with() {
        return new With(this);
    }

    public record With(Point source) {
        public Point x(int x) {
            return new Point(x, source.y());
        }

        public Point y(int y) {
            return new Point(source.x(), y);
        }
    }
}
