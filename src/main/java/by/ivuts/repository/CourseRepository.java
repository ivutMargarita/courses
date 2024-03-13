package by.ivuts.repository;

import by.ivuts.model.Course;

import java.util.List;

public interface CourseRepository {

    Course findById(Long id);

    List<Course> findAll();

    void insert(Course course);

    void update(Course course);

    void delete(Long id);

}
