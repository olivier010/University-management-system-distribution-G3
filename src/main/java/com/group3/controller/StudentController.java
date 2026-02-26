package com.group3.controller;

import com.group3.service.StudentService;
import com.group3.service.DepartmentService;
import com.group3.entity.Student;
import com.group3.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public String listStudents(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            Model model) {

        // Ensure page is at least 1
        if (page < 1) page = 1;

        List<Student> students = studentService.getStudents(page, size);
        long totalStudents = studentService.getStudentCount();
        int totalPages = (int) Math.ceil((double) totalStudents / size);

        model.addAttribute("students", students);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Student student = new Student();
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        if (student.getId() != null) {
            studentService.updateStudent(student);
        } else {
            studentService.saveStudent(student);
        }
        return "redirect:/students/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") Long id, Model model) {
        Student student = studentService.getStudent(id);
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
}
