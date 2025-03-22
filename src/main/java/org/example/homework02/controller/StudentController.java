package org.example.homework02.controller;


import org.example.homework02.model.dto.ApiReponse.ApiResponse;
import org.example.homework02.model.dto.request.StudentRequest;
import org.example.homework02.model.entity.Course;
import org.example.homework02.model.entity.Student;
import org.example.homework02.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<List<Student>>builder()
                        .success(true)
                        .message("Get All Students successfully")
                        .status(HttpStatus.OK)
                        .payload(studentService.getAllStudents(size, page))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> postStudent(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Student>builder()
                        .success(true)
                        .message("Post Students successfully")
                        .status(HttpStatus.OK)
                        .payload(studentService.postStudent(studentRequest))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Integer studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Student>builder()
                        .success(true)
                        .message("Get Course By Student Id successfully")
                        .status(HttpStatus.OK)
                        .payload(studentService.getStudentById(studentId))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }


    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> putStudentById(@PathVariable("student-id") Integer studentId , @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Student>builder()
                        .success(true)
                        .message("Update Student Id successfully")
                        .status(HttpStatus.OK)
                        .payload(studentService.putStudentById(studentId,studentRequest))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }


    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(@PathVariable("student-id") Integer studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.<Student>builder()
                    .success(true)
                    .message("Delete Student Id successfully")
                    .status(HttpStatus.OK)
                    .payload(studentService.deleteStudentById(studentId))
                    .timestamp(LocalDateTime.now())
                    .build()
        );
    }

}
