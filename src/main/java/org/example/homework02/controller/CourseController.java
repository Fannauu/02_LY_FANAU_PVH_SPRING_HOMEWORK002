package org.example.homework02.controller;

import org.example.homework02.model.dto.ApiReponse.ApiResponse;
import org.example.homework02.model.dto.request.CourseRequest;
import org.example.homework02.model.entity.Course;
import org.example.homework02.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {

        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<List<Course>>builder()
                        .success(true)
                        .message("Get All Courses Successfully")
                        .status(HttpStatus.OK)
                        .payload(courseService.getAllCourses(page, size))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> postCourse(@RequestBody CourseRequest courseRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Course>builder()
                        .success(true)
                        .message("Get All Courses Successfully")
                        .status(HttpStatus.OK)
                        .payload(courseService.postCourse(courseRequest))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> putCourse(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Course>builder()
                        .success(true)
                        .message("Get  Courses by id Successfully")
                        .status(HttpStatus.OK)
                        .payload(courseService.getCourseById(id))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable("id") Integer id, @RequestBody CourseRequest courseRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Course>builder()
                        .success(true)
                        .message("Get  Courses by id Successfully")
                        .status(HttpStatus.OK)
                        .payload(courseService.updateCourse(id, courseRequest))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Course>builder()
                        .success(true)
                        .message("Get  Courses by id Successfully")
                        .status(HttpStatus.OK)
                        .payload(courseService.deleteCourse(id))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
}
