package io.github.miinhho.chapter_5;

public record Time(int minutes, int seconds) {
    public Time {
        if (seconds >= 60) {
            int additionalMinutes = seconds / 60;
            minutes += additionalMinutes;
            seconds -= additionalMinutes * 60;
        }
    }
}
