package com.group3.service;

import com.group3.dao.DepartmentDAO;
import com.group3.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    public List<Department> getDepartments(int page, int size) {
        return departmentDAO.findAll(page, size);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    public long getDepartmentCount() {
        return departmentDAO.count();
    }

    public void saveDepartment(Department department) {
        departmentDAO.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentDAO.findById(id);
    }

    public void updateDepartment(Department department) {
        departmentDAO.update(department);
    }

    public void deleteDepartment(Long id) {
        departmentDAO.delete(id);
    }
}
