package by.ivuts.controller;

import by.ivuts.dto.CourseCreateAndUpdateDto;
import by.ivuts.dto.CourseDto;
import by.ivuts.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.findAll();
    }

    @PostMapping
    public void createCourse(@RequestBody CourseCreateAndUpdateDto courseDto) {
        courseService.insert(courseDto);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseCreateAndUpdateDto courseDto) {
        courseService.update(id, courseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }
}
