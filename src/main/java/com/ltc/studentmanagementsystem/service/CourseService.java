package com.ltc.studentmanagementsystem.service;

import com.ltc.studentmanagementsystem.model.CourseEntity;
import com.ltc.studentmanagementsystem.repo.CourseRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;


    //C
    public CourseEntity create(CourseEntity courseEntity){
    return courseRepo.save(courseEntity);
    }


    //R
    public CourseEntity getById(Long id){
        return courseRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Course not found"));
    }




}
