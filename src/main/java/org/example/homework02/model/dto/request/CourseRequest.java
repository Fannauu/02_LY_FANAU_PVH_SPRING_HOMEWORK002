package org.example.homework02.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework02.model.entity.Instructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String name;
    private String description;
    private Integer instructorId;
}
