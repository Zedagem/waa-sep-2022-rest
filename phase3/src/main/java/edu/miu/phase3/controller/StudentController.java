package edu.miu.phase3.controller;



import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.dto.StudentDto;
import edu.miu.phase3.entity.Course;
import edu.miu.phase3.entity.Student;
import edu.miu.phase3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PutMapping({"/{id}"})
    public void update(@PathVariable int id, @RequestBody StudentDto student) {
        studentService.update(id,student);
    }

    // Get student by major
    @GetMapping("/filter")
   public List<StudentDto> getStudentsByMajor(@RequestParam (required = true) String major ){
    return studentService.getStudentsByMajor(major);
   }

   // Get all the courses of the student with ID
    @GetMapping("/{studentId}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }


}
