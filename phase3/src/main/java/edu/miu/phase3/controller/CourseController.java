package edu.miu.phase3.controller;


import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.entity.Course;
import edu.miu.phase3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public void save(@RequestBody CourseDto course){
        courseService.save(course);
    }
    @GetMapping
    public List<CourseDto> courses(){
      return courseService.findAll();
    }

    @GetMapping("/{code}")
    public CourseDto getByCourseCode(@PathVariable String code){
        return courseService.getByCourseCode(code);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseDto course){
         courseService.update(id,course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

}
