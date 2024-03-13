package by.ivuts.service;

import by.ivuts.dto.CourseCreateAndUpdateDto;
import by.ivuts.dto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto findById(Long id);

    List<CourseDto> findAll();

    void insert(CourseCreateAndUpdateDto dto);

    void update(Long id, CourseCreateAndUpdateDto dto);

    void delete(Long id);

}
