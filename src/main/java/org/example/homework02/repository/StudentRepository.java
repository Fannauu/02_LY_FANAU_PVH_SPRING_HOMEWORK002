package org.example.homework02.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework02.model.dto.request.StudentRequest;
import org.example.homework02.model.entity.Student;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
                 select * from students
                 offset #{size} * (#{page} - 1)
                 limit #{size}
            """)
    @Results(id = "studentMapper", value = {
            @Result(property = "id", column = "student_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "course", column = "student_id",
                    many = @Many(select = "org.example.homework02.repository.CourseRepository.getCoursesByStudentId")
            )

    })
    List<Student> getAllStudents(Integer size, Integer page);

    @Select("""
                INSERT INTO students(student_name,email,phone_number)
                VALUES (#{request.name},#{request.email},#{request.phoneNumber})
                RETURNING  *
            """)
    @ResultMap("studentMapper")
    Student postStudent(@Param("request") StudentRequest studentRequest);


//    insert into middle table
    @Insert("""
        INSERT INTO student_course(student_id,course_id)
        VALUES(#{studentId},#{courseId})
        RETURNING  *
    """)
    void addStudentIdAndCourseId(Integer studentId, Integer courseId);

//    deleted from middle table

    @Select("""
        DELETE FROM student_course
        WHERE student_id = #{studentId}
    """)
    void deleteStudentIdAndCourseId(Integer studentId);



    @Select("""
              SELECT * FROM students WHERE student_id = #{studentId}
            """)
    @ResultMap("studentMapper")
    Student getStudentById(Integer studentId);



    @Select("""
        UPDATE students set student_name = #{request.name},email = #{request.email}, phone_number = #{request.phoneNumber}
        WHERE student_id = #{studentId}
        RETURNING *
    """)
    @ResultMap("studentMapper")
    void putStudentById(Integer studentId , @Param("request") StudentRequest studentRequest);


    @Select("""
        DELETE FROM students WHERE student_id = #{studentId}
    """)
    @ResultMap("studentMapper")
    Student deleteStudentById(Integer studentId);


}
