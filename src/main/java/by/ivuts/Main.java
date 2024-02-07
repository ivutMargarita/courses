package by.ivuts;

import by.ivuts.connection.DataSource;
import by.ivuts.model.User;
import by.ivuts.repository.CourseRepository;
import by.ivuts.repository.RoleRepository;
import by.ivuts.repository.UserRepository;
import org.postgresql.ds.PGSimpleDataSource;

import java.util.List;

public class Main {
    // сконфигурировать Hibernate ПОСЛЕДНЕЙ ВЕРСИИ (hibernate.cfg.xml)
    // перевести сущности на Hibernate
    // перевести репозитории на Hibernate

    public static void main(String[] args) throws Exception {
        PGSimpleDataSource dataSource = new DataSource().createDataSource();
        UserRepository userRepository = new UserRepository(dataSource);
        RoleRepository roleRepository = new RoleRepository(dataSource);
        CourseRepository courseRepository = new CourseRepository(dataSource);
//        User user1 = userRepository.findById(1L);
//        System.out.println(roleRepository.findById(1L));
//        user1.setUsername("123");
//        User user = new User(1L, "Marharyta", "7958", true, null);
//        User user2 = new User(2L, "Marharya", "12", true, null);
//        Role role = new Role(1L,"PC");
//        Role role2 = new Role(2L,"manager");
//        role.setName("Economics");
//        roleRepository.update(role);
//        System.out.println(roleRepository.findAll());
//        roleRepository.insert(role2);
//        Course course = new Course(5L,"Web-designer",5,10L);
//        Course course1 = new Course(20L,"something",40,100L);
//        System.out.println(courseRepository.findById(3L));
//        course.setHours(10);
//        courseRepository.update(course);
//        System.out.println(courseRepository.findAll());
//        Course course2 = new Course(10L,"anything",54,5L);
//        courseRepository.insert(course2);
//        courseRepository.delete(4L);
        List<User> all = userRepository.findAll();
//        roleRepository.delete(13L);
//        roleRepository.delete(22L);
//        userRepository.update(user1);
//        userRepository.findAll();
//        System.out.println(userRepository.findAll());
//        Long generatedId = userRepository.insert(user2);
//        System.out.println(generatedId);

//        userRepository.delete(1L);


//        User user1 = new User(1L, "Marhaya", "7958", true, LocalDate.of(2023, 12, 07));
//        Course course = new Course(1L, "Programming", 262, 1L);
//        Role role1 = new Role(1L, "Bla");
//        Role role2 = new Role(1L, "Bla");
//        System.out.println(role1.equals(role2));
//        System.out.println(role1.hashCode());
//        System.out.println(role2.hashCode());

    }
}