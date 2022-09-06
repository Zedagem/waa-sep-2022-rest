package edu.miu.phase3.service;




import edu.miu.phase3.entity.Course;
import edu.miu.phase3.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public void save(Student student);

    public void delete(int id);
    public void update(int id, Student student);
    public List<Student> getStudentsByMajor(String major );
    public List<Course> getCoursesByStudentId(int studentId);
}
