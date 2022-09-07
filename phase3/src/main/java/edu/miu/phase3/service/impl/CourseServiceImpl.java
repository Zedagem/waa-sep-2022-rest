package edu.miu.phase3.service.impl;



import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.entity.Course;
import edu.miu.phase3.repo.CourseRepo;
import edu.miu.phase3.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = courseRepo.getAll();
        List<CourseDto> courseDtos = new ArrayList<>();

        //using model mapper to change Course to CourseDto
        courses.forEach(course -> courseDtos.add(mapper.map(course,CourseDto.class)));
        return courseDtos;
    }

    @Override
    public CourseDto getByCourseCode(String code) {
        return mapper.map(courseRepo.findByCode(code),CourseDto.class);

    }

    @Override
    public void save(CourseDto course) {
        // Convert CourseDto to Course
        var courseEntity = mapper.map(course,Course.class);
        courseRepo.save(courseEntity);
    }

    @Override
    public void delete(int id) {
        courseRepo.deleteCourse(id);
    }

    @Override
    public void update(int id, CourseDto course) {
        // Convert CourseDto to Course
        var courseEntity = mapper.map(course,Course.class);
        courseRepo.updateCourse(id,courseEntity);
    }
}
