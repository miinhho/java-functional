package io.github.miinhho.chapter_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import io.github.miinhho.chapter_5.builder.UserBuilder;
import io.github.miinhho.chapter_5.record_constructor.Rectangle;
import io.github.miinhho.chapter_5.serialize.SerializablePoint;
import io.github.miinhho.chapter_5.wither.Point;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        userRecordExample();
        recordConstructorExample();
        userBuilderExample();
        userBuilderInUserRecord();
        timeExample();
        witherExample();
        serializeRecord();
    }

    static void userRecordExample() {
        var user = new User("John Doe", true, LocalDateTime.now());
        var username = user.username();
    }

    static void recordConstructorExample() {
        var rectangle = new Rectangle(23, 42, 300, 400);
        var xOnlyRectangle = Rectangle.atX(23, 300, 400);
    }

    static void userBuilderExample() {
        var builder = new UserBuilder("ben")
                .active(false)
                .lastLogin(LocalDateTime.now());
        var user = builder.build();
    }

    static void userBuilderInUserRecord() {
        var builder = new User.Builder("ben");
    }

    static void timeExample() {
        var time = new Time(12, 67);
    }

    static void witherExample() {
        var sourcePoint = new Point(23, 42);
        var modifiedPoint = sourcePoint.with().x(5);
    }

    static List<String> filterAlbums(Map<Integer, List<String>> albums, int minimumYear) {
        return albums.entrySet()
                .stream()
                .filter(entry -> entry.getKey() >= minimumYear)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .toList();
    }

    static List<String> filterAlbumsWithLocalRecord(Map<Integer, List<String>> albums, int minimumYear) {

        record AlbumsPerYear(int year, List<String> titles) {
            public AlbumsPerYear(Map.Entry<Integer, List<String>> entry) {
                this(entry.getKey(), entry.getValue());
            }

            public static Predicate<AlbumsPerYear> minumumYear(int year) {
                return albumsPerYear -> albumsPerYear.year() >= year;
            }

            public static Comparator<AlbumsPerYear> sortByYear() {
                return Comparator.comparing(AlbumsPerYear::year);
            }
        }

        return albums.entrySet()
                .stream()
                .map(AlbumsPerYear::new)
                .filter(AlbumsPerYear.minumumYear(minimumYear))
                .sorted(AlbumsPerYear.sortByYear())
                .map(AlbumsPerYear::titles)
                .flatMap(List::stream)
                .toList();
    }

    static void serializeRecord() {
        var point = new SerializablePoint(23, 42);

        try (var out = new ObjectOutputStream(new FileOutputStream("point.data"))) {
            out.writeObject(point);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deserializeRecord() {
        try (var in = new ObjectInputStream(new FileInputStream("point.data"))) {
            var point = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
