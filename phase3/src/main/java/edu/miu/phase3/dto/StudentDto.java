package edu.miu.phase3.dto;

import edu.miu.phase3.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    float gpa;
    List<Course> coursesTaken;
}
