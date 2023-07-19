package com.k14.controller;

import com.k14.model.Student;
import com.k14.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public ModelAndView getPageA() {
        ModelAndView modelAndView = new ModelAndView("pageA");
        return modelAndView;
    }

    @GetMapping("/pageb/{id}/{age}")
    public String getPageB(@PathVariable int id, @PathVariable int age) {
        System.out.println(id);
        return "pageB";
    }

    @GetMapping("/home")
    public String home(@RequestParam int x, @RequestParam String b, Model model) {
        int a = 1000000;
        model.addAttribute("number", a);
        model.addAttribute("x", x);
        model.addAttribute("b", b);
        return "home";
    }

    @GetMapping("/dang-ky")
    public String create(Model model) {
        model.addAttribute("message", "Hello World");
        model.addAttribute("name", "Le Duy");
        Student student = new Student();
        model.addAttribute("student", student);

        return "dang-ky-hoc-sinh";
    }

    @PostMapping("/save")
    public String postStudent(@ModelAttribute Student student) {
        System.out.println(student);
        return "redirect:/student/danh-sach";
    }

    @GetMapping("/teacher")
    public String teacher(Model model) {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setTname("Duy");
        teacher.setAddress("Ha Noi");
        model.addAttribute("teacher", teacher);
        return "teacher";
    }


    @GetMapping("/danh-sach")
    public String list(Model model) {
        ArrayList<Student> list = new ArrayList<>();
        Student student = new Student(1, "Duy", "VP");
        Student student1 = new Student(2, "Lien", "VP");
        Student student2 = new Student(3, "Bang", "VP");
        list.add(student);
        list.add(student1);
        list.add(student2);
        model.addAttribute("list", list);
        return "danh-sach-hoc-sinh";
    }

    @GetMapping("/list-gv")
    public String listGV(Model model) {
        ArrayList<Teacher> list = new ArrayList<>();
        Teacher teacher = new Teacher(1, "Le Van A", "Ha Noi");
        Teacher teacher2 = new Teacher(2, "Le Van C", "Ha Noi");
        Teacher teacher3 = new Teacher(3, "Le Van B", "Ha Noi");
        list.add(teacher3);
        list.add(teacher2);
        list.add(teacher);
        model.addAttribute("list", list);
        return "danh-sach-giao-vien";
    }

    @GetMapping("dang-ky-giao-vien")
    public String dkgiaovien(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "dang-ky-giao-vien";
    }
    @PostMapping("/save-gv")
    public String postGiaoVien(@ModelAttribute Teacher teacher){
        System.out.println(teacher);
        return "redirect:/student/list-gv";
    }


}
