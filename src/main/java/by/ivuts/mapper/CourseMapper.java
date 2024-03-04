package by.ivuts.mapper;

import by.ivuts.dto.CourseCreateAndUpdateDto;
import by.ivuts.dto.CourseDto;
import by.ivuts.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper // сделать бином
public interface CourseMapper {

    CourseDto toDto(Course course);

    List<CourseDto> toDto(List<Course> courses);

    Course toEntity(CourseCreateAndUpdateDto dto);

}
