package io.github.miinhho.chapter_5;

import java.util.Collections;
import java.util.List;

public record IncreaseImmutability(List<String> values) {
    public IncreaseImmutability {
        values = Collections.unmodifiableList(values);
    }
}
