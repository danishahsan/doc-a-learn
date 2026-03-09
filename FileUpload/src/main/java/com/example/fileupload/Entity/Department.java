package com.example.fileupload.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"employees_id","jobTitle"}))
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String jobTitle;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "employees_id")
    Employee employee;

    
//    public Department(String jobTitles, Employee employee) {
//        this.employee=employee;
//        this.jobTitle = jobTitle;
//    }

//    public String getJobTitle() {
//        return jobTitle;
//    }
}