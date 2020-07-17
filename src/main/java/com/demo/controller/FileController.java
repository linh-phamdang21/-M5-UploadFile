package com.demo.controller;

import com.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class FileController {

    @Autowired
    private Environment env;

    public List student = new ArrayList();
    @GetMapping
    public ModelAndView home(){
        Student student = new Student();
        ModelAndView modelAndView = new ModelAndView("views/uploadFile");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView addStudent(@ModelAttribute Student student) throws Exception{
        ModelAndView modelAndView = new ModelAndView("views/showStudent");
        Student newStudent = new Student(student.getId(), student.getName(),
                student.getAge(), student.getClassName(), null);
        MultipartFile multipartFile = student.getImages();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload");
        try {
            FileCopyUtils.copy(student.getImages().getBytes(), new File(fileUpload + fileName));
        } catch (Exception e){
            e.printStackTrace();
        }
        newStudent.setImage(fileName);
        modelAndView.addObject("newStudent", newStudent);
        return modelAndView;
    }
}
