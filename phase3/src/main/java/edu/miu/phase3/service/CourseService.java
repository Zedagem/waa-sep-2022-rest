package edu.miu.phase3.service;


import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.entity.Course;

import java.util.List;

public interface CourseService {
    public List<CourseDto> findAll();
    public CourseDto getByCourseCode(String code);
    public void save(CourseDto course);

    public void delete(int id);
    public void update(int id, CourseDto course);
}
