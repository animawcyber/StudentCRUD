package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.stud;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
    
     @Autowired
        private StudentService service;

        @GetMapping("/")
        public String viewHomePage(Model model) {
            List<stud> liststudent = service.listAll();
            model.addAttribute("liststudent", liststudent);
            System.out.print("Get / ");    
            return "index";
        }

        @GetMapping("/new")
        public String add(Model model) {
            model.addAttribute("student", new stud());
            return "new";
        }

        @PostMapping("/save")
        public String saveStudent(@ModelAttribute("student") stud std) {
            service.save(std);
            return "redirect:/";
        }

        @RequestMapping("/edit/{id}")
        public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("new");
            stud std = service.get(id);
            mav.addObject("student", std);
            return mav;
            
        }
        @RequestMapping("/delete/{id}")
        public String deletestudent(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/";
        }
}
