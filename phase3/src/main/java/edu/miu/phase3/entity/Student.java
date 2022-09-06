package edu.miu.phase3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    float gpa;
    List<Course> coursesTaken;

}
