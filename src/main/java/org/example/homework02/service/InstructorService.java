package org.example.homework02.service;

import org.example.homework02.model.dto.request.InstructorRequest;
import org.example.homework02.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Integer size, Integer page);
    Instructor postInstructor(InstructorRequest request);
    Instructor getInstructorById(Integer id);

    Instructor updateInstructorById(Integer id, InstructorRequest request);

    Instructor deletedInstructorById(Integer id);
}
