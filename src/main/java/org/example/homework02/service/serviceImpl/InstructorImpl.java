package org.example.homework02.service.serviceImpl;

import org.example.homework02.model.dto.request.InstructorRequest;
import org.example.homework02.model.entity.Instructor;
import org.example.homework02.repository.InstructorRepository;
import org.example.homework02.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getAllInstructors(Integer size, Integer page) {
        return instructorRepository.getAllInstructors(size,page);
    }

    @Override
    public Instructor postInstructor(InstructorRequest request) {
        return instructorRepository.postInstructor(request);
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor updateInstructorById(Integer id, InstructorRequest request) {
        return instructorRepository.updateInstructorById(id,request);
    }

    @Override
    public Instructor deletedInstructorById(Integer id) {
        return instructorRepository.deletedInstructorById(id);
    }


}
