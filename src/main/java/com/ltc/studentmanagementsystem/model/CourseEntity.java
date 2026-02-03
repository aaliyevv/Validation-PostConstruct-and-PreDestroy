package com.ltc.studentmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table (name = "Courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name is required")
    @Size(min = 1, message = "Not less than 1 character")
    private String courseName;

    @DecimalMin(value = "100", message = "Not less than 100 AZN")
    private double price;

    @Size(max = 50, message = "Not more than 50 characters")
    private String address;

}
