package com.group3.controller;

import com.group3.entity.Course;
import com.group3.service.CourseService;
import com.group3.service.DepartmentService;
import com.group3.entity.Department;
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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public String listCourses(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            Model model) {

        if (page < 1) page = 1;

        List<Course> courses = courseService.getCourses(page, size);
        long totalCourses = courseService.getCourseCount();
        int totalPages = (int) Math.ceil((double) totalCourses / size);

        model.addAttribute("courses", courses);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "list-courses";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Course course = new Course();
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("course", course);
        model.addAttribute("departments", departments);
        return "course-form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        if (course.getId() != null) {
            courseService.updateCourse(course);
        } else {
            courseService.saveCourse(course);
        }
        return "redirect:/courses/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") Long id, Model model) {
        Course course = courseService.getCourse(id);
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("course", course);
        model.addAttribute("departments", departments);
        return "course-form";
    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam("courseId") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/list";
    }
}
