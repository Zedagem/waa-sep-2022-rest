package edu.miu.phase3.service.impl;


import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.dto.StudentDto;
import edu.miu.phase3.entity.Course;
import edu.miu.phase3.entity.Student;
import edu.miu.phase3.repo.StudentRepo;
import edu.miu.phase3.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        students.forEach(student -> studentDtos.add(mapper.map(student,StudentDto.class)));
        return studentDtos;
    }

    @Override
    public StudentDto findById(int id) {
        return mapper.map(studentRepo.findById(id),StudentDto.class);
    }

    @Override
    public void save(StudentDto student) {
        studentRepo.save(mapper.map(student,Student.class));
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public void update(int id, StudentDto student) {
        var studentEntity = mapper.map(student,Student.class);
        studentRepo.update(id,studentEntity);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> students = studentRepo.getStudentsByMajor(major);
        List<StudentDto> studentDtos = new ArrayList<>();
        // Converting Student entity to StudentDto
        students.forEach(student -> studentDtos.add(mapper.map(student,StudentDto.class)));
        return studentDtos;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        List<Course> courses = studentRepo.getCoursesByStudentId(studentId);
        List<CourseDto> courseDtos = new ArrayList<>();
        // Converting Course Entity to CourseDto
        courses.forEach(course -> courseDtos.add(mapper.map(course,CourseDto.class)));
        return courseDtos;
    }
}
