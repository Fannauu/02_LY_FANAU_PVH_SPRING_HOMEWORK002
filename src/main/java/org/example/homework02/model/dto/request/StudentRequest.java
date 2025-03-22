package org.example.homework02.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private List <Integer> courseIds;
}
