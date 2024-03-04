package by.ivuts.service;

import by.ivuts.model.Course;
import by.ivuts.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public Course findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void insert(Course course) {
        courseRepository.insert(course);
    }

    public void update(Course course) {
        courseRepository.update(course);
    }

    public void delete(Long id) {
        courseRepository.delete(id);
    }

}
