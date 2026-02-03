package com.ltc.studentmanagementsystem.controller;

import com.ltc.studentmanagementsystem.model.StudentEntity;
import com.ltc.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studetnService) {
        this.studentService = studetnService;
    }


    //C
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity create(@Valid @RequestBody StudentEntity studentEntity){
        return studentService.create(studentEntity);
    }


    //R
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity getById(@PathVariable Long id){
        return studentService.getById(id);
    }


    //R
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> getAll(){
        return studentService.getAll();
    }


    //U
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentEntity update(@PathVariable Long id,
                                @Valid @RequestBody StudentEntity studentEntity){
        return studentService.update(id, studentEntity);
    }


    //D
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }


}