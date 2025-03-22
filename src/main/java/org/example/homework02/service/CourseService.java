package org.example.homework02.service;


import org.example.homework02.model.dto.request.CourseRequest;
import org.example.homework02.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(Integer page, Integer size);

    Course postCourse(CourseRequest courseRequest);

    Course getCourseById(Integer id);

    Course updateCourse(Integer id ,CourseRequest courseRequest);

    Course deleteCourse(Integer id);

}
