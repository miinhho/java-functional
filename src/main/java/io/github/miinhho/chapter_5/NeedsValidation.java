package io.github.miinhho.chapter_5;

public record NeedsValidation(int x, int y) {
    public NeedsValidation {
        if (x < y) {
            throw new IllegalArgumentException("x must be equal or greater than y");
        }
    }
}
