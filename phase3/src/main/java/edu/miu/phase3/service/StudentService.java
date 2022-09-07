package edu.miu.phase3.service;




import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.dto.StudentDto;
import edu.miu.phase3.entity.Course;
import edu.miu.phase3.entity.Student;

import java.util.List;

public interface StudentService {
    public List<StudentDto> findAll();
    public StudentDto findById(int id);
    public void save(StudentDto student);

    public void delete(int id);
    public void update(int id, StudentDto student);
    public List<StudentDto> getStudentsByMajor(String major );
    public List<CourseDto> getCoursesByStudentId(int studentId);
}
