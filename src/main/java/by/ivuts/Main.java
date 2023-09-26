package by.ivuts;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        User user2 = new User(1L, "Marry", "7958", true, LocalDate.of(2023, 12, 07));
        User user1 = new User(1L, "Marhaya", "7958", true, LocalDate.of(2023, 12, 07));
        Teacher teacher = new Teacher(1L, "Andey", "Yuryev", "professor", 1L);
        Student student = new Student(1L, "Nastya", "Yurkova", 10, "new", 1L);
        Course course = new Course(1L, "Programming", 262, 1L);
        Role role1 = new Role(1L, "Bla");
        Role role2 = new Role(1L, "Bla");
        System.out.println(role1.equals(role2));
        System.out.println(role1.hashCode());
        System.out.println(role2.hashCode());
    }
}