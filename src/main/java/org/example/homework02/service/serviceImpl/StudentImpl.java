package org.example.homework02.service.serviceImpl;

import org.example.homework02.model.dto.request.StudentRequest;
import org.example.homework02.model.entity.Course;
import org.example.homework02.model.entity.Student;
import org.example.homework02.repository.CourseRepository;
import org.example.homework02.repository.StudentRepository;
import org.example.homework02.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {
    private final StudentRepository studentRepository;
//    private final CourseRepository courseRepository;

    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(Integer size, Integer page) {
        return studentRepository.getAllStudents(size, page);
    }

    @Override
    public Student postStudent(StudentRequest studentRequest) {
        Student student = studentRepository.postStudent(studentRequest);
//        call function deleted before insert or update
        for(Integer courseId : studentRequest.getCourseIds()) {
            studentRepository.addStudentIdAndCourseId(student.getId(), courseId);
        }
        return getStudentById(student.getId());
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student putStudentById(Integer studentId, StudentRequest studentRequest) {
        studentRepository.deleteStudentIdAndCourseId(studentId);
        studentRepository.putStudentById(studentId, studentRequest);
        Student student =  studentRepository.getStudentById(studentId);
        for(Integer courseId : studentRequest.getCourseIds()) {
            studentRepository.addStudentIdAndCourseId(student.getId(), courseId);
        }
        return getStudentById(student.getId());
    }

    @Override
    public Student deleteStudentById(Integer studentId) {
        return studentRepository.deleteStudentById(studentId);
    }


}
