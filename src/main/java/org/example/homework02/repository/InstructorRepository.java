package org.example.homework02.repository;


import org.apache.ibatis.annotations.*;
import org.example.homework02.model.dto.request.InstructorRequest;
import org.example.homework02.model.entity.Instructor;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Select("""
        select * from instructors
        offset #{size} * (#{page} -1 )
        limit #{size}
    """)
    @Results(id = "instructorMapper",value = {
            @Result(property = "id",column = "instructor_id"),
            @Result(property = "name",column = "instructor_name"),
    })
    List<Instructor> getAllInstructors(Integer size, Integer page);


    @Select("""
        INSERT INTO instructors(instructor_name,email)
        VALUES (#{request.instructorName},#{request.email})
        RETURNING * ;
    """)
    @ResultMap("instructorMapper")
    Instructor postInstructor(@Param("request") InstructorRequest request);


    @Select("""
        select * from instructors
        where instructor_id = #{id}
    """)
    @ResultMap("instructorMapper")
     Instructor getInstructorById(Integer id);


    @Select("""
        UPDATE instructors
        set instructor_name = #{request.instructorName},email = #{request.email}
        where instructor_id = #{id}
        returning *
    """)
    @ResultMap("instructorMapper")
    Instructor updateInstructorById( Integer id,@Param("request") InstructorRequest request);


    @Select("""
        DELETE FROM instructors
        where instructor_id = #{id}
    """)
    @ResultMap("instructorMapper")
    Instructor deletedInstructorById(Integer id);
}
