package org.example.homework02.service;

import org.example.homework02.model.dto.request.StudentRequest;
import org.example.homework02.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents(Integer size, Integer page);

    Student postStudent(StudentRequest studentRequest);

    Student getStudentById(Integer studentId);

    Student putStudentById(Integer studentId,StudentRequest studentRequest);

    Student deleteStudentById(Integer studentId);

//    Student getCourseByStudentId(Integer studentId);
}
