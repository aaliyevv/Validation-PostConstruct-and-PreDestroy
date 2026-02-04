package com.ltc.studentmanagementsystem.controller;

import com.ltc.studentmanagementsystem.model.CourseEntity;
import com.ltc.studentmanagementsystem.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    //C
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseEntity create(@Valid @RequestBody CourseEntity courseEntity){
        return courseService.create(courseEntity);
    }


    //R
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseEntity getById(@PathVariable Long id){
        return courseService.getById(id);
    }

}
