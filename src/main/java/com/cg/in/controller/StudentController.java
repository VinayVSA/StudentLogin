package com.cg.in.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cg.in.entity.User;
import com.cg.in.service.StudentService;
import com.cg.in.service.UserService;

@Controller
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        userService.saveUser(user);
        return "redirect:/login";
    }
}