package com.example.fileupload.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.engine.FetchStyle;
import org.hibernate.engine.FetchTiming;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDate;
import java.util.List;

@ToString
@Entity
@Getter
@Setter
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//  @JsonProperty("first_name")
    @Column(name="firstname")
    String firstName;

//  @JsonProperty("last_name")
    @Column(name="lastname")
    String lastName;
    @Column(name="email")
    String email;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.REMOVE,CascadeType.REFRESH})
    @JsonManagedReference
    List<Department> departments;

    @Column(name="gender")
    String gender;

    @CreationTimestamp(source = SourceType.DB)
    @Column(name="joined_Date", updatable = false)
    LocalDate createdAt;

    @UpdateTimestamp
    @Column(name="employee_modified",  insertable = false)
    LocalDate changed;

//    public Employee() {
//    }

//    public Employee(String firstName, String lastName, String email, String gender, List<Department> departments ,LocalDate createdAt, LocalDate changed) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.gender = gender;
//
//        this.departments=departments;
//        this.createdAt = createdAt;
//        this.changed = changed;
//    }
//    public Long getId() {
//        return id;
//    }

}