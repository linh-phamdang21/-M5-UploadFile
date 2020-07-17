package com.demo.model;

import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

public class Student {
    private Long id;
    private String name;
    private int age;
    private String className;
    private String image;

    public Student(){

    }

    public Student(Long id, String name, int age, String className, String image){
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Transient
    public MultipartFile images;

    public MultipartFile getImages() {
        return images;
    }

    public void setImages(MultipartFile images) {
        this.images = images;
    }
}
