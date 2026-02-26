package com.group3.service;

import com.group3.dao.CourseDAO;
import com.group3.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseDAO courseDAO;

    public List<Course> getCourses(int page, int size) {
        return courseDAO.findAll(page, size);
    }

    public long getCourseCount() {
        return courseDAO.count();
    }

    public void saveCourse(Course course) {
        courseDAO.save(course);
    }

    public Course getCourse(Long id) {
        return courseDAO.findById(id);
    }

    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    public void deleteCourse(Long id) {
        courseDAO.delete(id);
    }
}

