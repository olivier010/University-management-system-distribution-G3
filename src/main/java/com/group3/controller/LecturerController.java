package com.group3.controller;

import com.group3.entity.Lecturer;
import com.group3.service.LecturerService;
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
@RequestMapping("/lecturers")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public String listLecturers(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            Model model) {

        if (page < 1) page = 1;

        List<Lecturer> lecturers = lecturerService.getLecturers(page, size);
        long totalLecturers = lecturerService.getLecturerCount();
        int totalPages = (int) Math.ceil((double) totalLecturers / size);

        model.addAttribute("lecturers", lecturers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "list-lecturers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Lecturer lecturer = new Lecturer();
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("departments", departments);
        return "lecturer-form";
    }

    @PostMapping("/saveLecturer")
    public String saveLecturer(@ModelAttribute("lecturer") Lecturer lecturer) {
        if (lecturer.getId() != null) {
            lecturerService.updateLecturer(lecturer);
        } else {
            lecturerService.saveLecturer(lecturer);
        }
        return "redirect:/lecturers/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("lecturerId") Long id, Model model) {
        Lecturer lecturer = lecturerService.getLecturer(id);
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("departments", departments);
        return "lecturer-form";
    }

    @GetMapping("/delete")
    public String deleteLecturer(@RequestParam("lecturerId") Long id) {
        lecturerService.deleteLecturer(id);
        return "redirect:/lecturers/list";
    }
}
