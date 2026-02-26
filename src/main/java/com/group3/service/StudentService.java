package com.group3.service;

import com.group3.dao.StudentDAO;
import com.group3.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
//student service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public List<Student> getStudents(int page, int size) {
        // In a real implementation with security, we would get the current user's
        // institution/college ID and filter accordingly here or in the DAO.
        // For example:
        // User user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // if (user.isCollegeAdmin()) {
        //     return studentDAO.findAllByCollege(user.getCollegeId(), page, size);
        // }

        return studentDAO.findAll(page, size);
    }

    public long getStudentCount() {
        return studentDAO.count();
    }

    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    public Student getStudent(Long id) {
        return studentDAO.findById(id);
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public void deleteStudent(Long id) {
        studentDAO.delete(id);
    }
}

