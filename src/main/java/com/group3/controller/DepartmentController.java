package com.group3.controller;

import com.group3.entity.Department;
import com.group3.service.DepartmentService;
import com.group3.service.CollegeService;
import com.group3.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/list")
    public String listDepartments(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            Model model) {

        if (page < 1) page = 1;

        List<Department> departments = departmentService.getDepartments(page, size);
        long totalDepartments = departmentService.getDepartmentCount();
        int totalPages = (int) Math.ceil((double) totalDepartments / size);

        model.addAttribute("departments", departments);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "list-departments";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "department-form";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        if (department.getId() != null) {
            departmentService.updateDepartment(department);
        } else {
            departmentService.saveDepartment(department);
        }
        return "redirect:/departments/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("departmentId") Long id, Model model) {
        Department department = departmentService.getDepartment(id);
        model.addAttribute("department", department);
        return "department-form";
    }

    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam("departmentId") Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments/list";
    }
}
