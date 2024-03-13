package by.ivuts.repository;

import by.ivuts.model.User;

import java.util.List;

public interface UserRepository {

    User findById(Long id);

    List<User> findAll();

    void insert(User user);

    void update(User user);

    void delete(Long id);

}
