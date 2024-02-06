package by.ivuts;

import by.ivuts.connection.DataSource;
import by.ivuts.model.User;
import by.ivuts.repository.UserRepository;
import org.postgresql.ds.PGSimpleDataSource;

public class Main {

    public static void main(String[] args) throws Exception {
        PGSimpleDataSource dataSource = new DataSource().createDataSource();
        UserRepository userRepository = new UserRepository(dataSource);
        User user1 = userRepository.findById(1L);
        user1.setUsername("123");
        User user = new User(1L, "Marharyta", "7958", true, null);
        User user2 = new User(2L, "Marharya", "12", true, null);
//        userRepository.update(user1);
//        userRepository.findAll();
//        System.out.println(userRepository.findAll());
        Long generatedId = userRepository.insert(user2);
        System.out.println(generatedId);
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