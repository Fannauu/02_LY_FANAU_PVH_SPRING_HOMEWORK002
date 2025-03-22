package org.example.homework02.repository;


import org.apache.ibatis.annotations.*;
import org.example.homework02.model.dto.request.CourseRequest;
import org.example.homework02.model.entity.Course;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("""
      SELECT * FROM courses
""")
    @Results(id = "courseMapper", value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "name", column = "course_name"),
            @Result(property = "instructorId" ,column = "instructor_id",
                    one = @One(select = "org.example.homework02.repository.InstructorRepository.getInstructorById")
            )
    })
    List<Course> getAllCourses();

    @Select("""
        INSERT INTO courses (course_name,description, instructor_id)
        VALUES (#{request.name},#{request.description},#{request.instructorId})
        RETURNING *
    """)
    @ResultMap("courseMapper")
    Course postCourse(@Param("request") CourseRequest courseRequest);



    @Select("""
        SELECT * FROM courses where course_id = #{id}
    """)
    @ResultMap("courseMapper")
    Course getCourseById(Integer id);


    @Select("""
        UPDATE courses set course_name= #{request.name},description = #{request.description},instructor_id = #{request.instructorId}
        where course_id = #{id}
        RETURNING *
    """)
    @ResultMap("courseMapper")
    Course updateCourse(Integer id, @Param("request") CourseRequest courseRequest);



    @Select("""
        DELETE FROM courses
        where course_id = #{id}
    """)
    @ResultMap("courseMapper")
    Course deleteCourse(Integer id);


    @Select("""
            
            SELECT c.course_id, c.course_name, c.description, c.instructor_id from courses c
            INNER JOIN student_course sc ON c.course_id = sc.course_id
            WHERE sc.student_id = #{studentId}
            """)
    @ResultMap("courseMapper")
    List<Course> getCoursesByStudentId(Integer studentId);


}