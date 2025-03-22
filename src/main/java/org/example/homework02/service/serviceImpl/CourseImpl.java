package org.example.homework02.service.serviceImpl;


import org.example.homework02.model.dto.request.CourseRequest;
import org.example.homework02.model.entity.Course;
import org.example.homework02.repository.CourseRepository;
import org.example.homework02.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course postCourse(CourseRequest courseRequest) {
        return courseRepository.postCourse(courseRequest);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course updateCourse(Integer id, CourseRequest courseRequest) {
        return courseRepository.updateCourse(id,courseRequest);
    }

    @Override
    public Course deleteCourse(Integer id) {
        return courseRepository.deleteCourse(id);
    }

}
