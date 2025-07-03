package io.github.miinhho.chapter_5;

import java.time.LocalDateTime;
import java.util.Objects;

public record User(
        String username,
        boolean active,
        LocalDateTime lastLogin) {

    public User {
        Objects.requireNonNull(username);
        Objects.requireNonNull(lastLogin);
        username = username.toLowerCase();
    }

    public static final class Builder {
        private String username;
        private boolean active = true;
        private LocalDateTime lastLogin;

        public Builder(String username) {
            this.username = username;
        }

        public Builder active(boolean isActive) {
            this.active = isActive;
            return this;
        }

        public Builder lastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public User build() {
            return new User(username, active, lastLogin);
        }
    }
}
