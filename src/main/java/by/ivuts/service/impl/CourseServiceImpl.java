package by.ivuts.service.impl;

import by.ivuts.dto.CourseCreateAndUpdateDto;
import by.ivuts.dto.CourseDto;
import by.ivuts.exception.ServiceException;
import by.ivuts.mapper.CourseMapper;
import by.ivuts.model.Course;
import by.ivuts.repository.CourseRepository;
import by.ivuts.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseDto findById(Long id) {
        try {
            Course course = courseRepository.findById(id);
            return courseMapper.toDto(course);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public List<CourseDto> findAll() {
        try {
            List<Course> courses = courseRepository.findAll();
            return courseMapper.toDto(courses);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void insert(CourseCreateAndUpdateDto dto) {
        try {
            Course course = courseMapper.toEntity(dto);
            courseRepository.insert(course);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void update(Long id, CourseCreateAndUpdateDto dto) {
        try {
            Course course = courseMapper.toEntity(dto);
            course.setId(id);
            courseRepository.update(course);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            courseRepository.delete(id);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

}
