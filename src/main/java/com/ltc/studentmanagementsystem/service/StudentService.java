package com.ltc.studentmanagementsystem.service;

import com.ltc.studentmanagementsystem.model.StudentEntity;
import com.ltc.studentmanagementsystem.repo.StudentRepo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;


    @PostConstruct
    public void init(){
        System.out.println("System is up");
    }


    // C
    public StudentEntity create(StudentEntity studentEntity) {
        return studentRepo.save(studentEntity);
    }


    //R
    public StudentEntity getById(Long id){
        return studentRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Student not found"));
    }


    //R
    public List<StudentEntity> getAll(){
        return studentRepo.findAll();
    }


    //U
    public StudentEntity update(Long id, StudentEntity studentEntity){
        StudentEntity oldStudent = studentRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Student not found"));

        oldStudent.setName(studentEntity.getName());
        oldStudent.setSurname(studentEntity.getSurname());
        oldStudent.setEmail(studentEntity.getEmail());
        oldStudent.setAddress(studentEntity.getPhoneNumber());
        oldStudent.setPhoneNumber(studentEntity.getPhoneNumber());

        return studentRepo.save(oldStudent);

    }


    //D
    public void delete(Long id){
        studentRepo.deleteById(id);
    }



    @PreDestroy
    void destroy(){
        studentRepo.deleteAll();
        System.out.println("Data has been deleted");
    }


}