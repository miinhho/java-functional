package io.github.miinhho.chapter_5.optional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public record User(
        String username,
        boolean active,
        Optional<String> group,
        LocalDateTime lastLogin) {

    // null 이 아닌 컨테이너 확보
    public User {
        Objects.requireNonNull(group, "Optional<String> group must not be null");
    }

    // 컴펙트 생성자 추가
    public User(String username, boolean active, String group, LocalDateTime lastLogin) {
        this(username, active, Optional.ofNullable(group), lastLogin);
    }
}
