package io.github.miinhho.chapter_5.builder;

import java.time.LocalDateTime;

import io.github.miinhho.chapter_5.User;

public final class UserBuilder {
    private final String username;
    private boolean active;
    private LocalDateTime lastLogin;

    public UserBuilder(String username) {
        this.username = username;
        this.active = true;
    }

    public UserBuilder active(boolean isActive) {
        if (active == false) {
            throw new IllegalArgumentException();
        }

        active = isActive;
        return this;
    }

    public UserBuilder lastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public User build() {
        return new User(username, active, lastLogin);
    }
}
