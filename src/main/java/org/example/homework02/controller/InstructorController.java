package org.example.homework02.controller;


import org.example.homework02.model.dto.ApiReponse.ApiResponse;
import org.example.homework02.model.dto.request.InstructorRequest;
import org.example.homework02.model.entity.Instructor;
import org.example.homework02.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {




    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(required = false) Integer size,@RequestParam(required = false) Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<List<Instructor>>builder()
                        .success(true)
                        .message("Get All Instructors successfully")
                        .status(HttpStatus.OK)
                        .payload(instructorService.getAllInstructors(size, page))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable("id") Integer id){
        return instructorService.getInstructorById(id);
    }

    @PostMapping()
    public Instructor postInstructor(@RequestBody InstructorRequest request) {
        return instructorService.postInstructor(request);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructorById(@PathVariable("id") Integer id, @RequestBody InstructorRequest request) {
        return instructorService.updateInstructorById(id,request);
    }

    @DeleteMapping("/{id}")
    public Instructor deletedInstructorById(@PathVariable("id") Integer id) {
        return instructorService.deletedInstructorById(id);
    }
}

