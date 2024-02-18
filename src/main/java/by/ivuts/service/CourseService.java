package by.ivuts.service;

import by.ivuts.dto.CourseCreateAndUpdateDto;
import by.ivuts.dto.CourseDto;
import by.ivuts.mapper.CourseMapper;
import by.ivuts.model.Course;
import by.ivuts.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseDto findById(Long id) {
        Course course = courseRepository.findById(id);
        return courseMapper.toDto(course);
    }

    public List<CourseDto> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toDto(courses);
    }

    public void insert(CourseCreateAndUpdateDto dto) {
        Course course = courseMapper.toEntity(dto);
        courseRepository.insert(course);
    }

    public void update(CourseCreateAndUpdateDto dto) {
        Course course = courseMapper.toEntity(dto);
        courseRepository.update(course);
    }

    public void delete(Long id) {
        courseRepository.delete(id);
    }

}
