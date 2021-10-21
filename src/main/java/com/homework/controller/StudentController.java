package com.homework.controller;

import com.homework.domain.Student;
import com.homework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/register")
    public String uploadFile(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("age") Integer age,
                             @RequestParam("photo")MultipartFile file) throws IOException {
        Student student = new Student(firstName,lastName,age);
        studentService.create(student, file);
        return "redirect:/student&id=" + student.getId();
    }
    @GetMapping("/student")
    public String studentForm(@RequestParam("id") Integer id , ModelMap modelMap) throws UnsupportedEncodingException {
        byte[] fileBytes = studentService.findById(id).getFileData();
        byte[] fileEncode = Base64.getEncoder().encode(fileBytes);
        String fileBaseEncoded = new String(fileEncode, "UTF-8");
        modelMap.addAttribute("student", studentService.findById(id));
        ModelMap photo = modelMap.addAttribute("photo",fileBaseEncoded);
        return "student";
    }

}
