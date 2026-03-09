package com.example.fileupload.Controller;


import com.example.fileupload.Entity.Department;
import com.example.fileupload.Entity.Employee;
import com.example.fileupload.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobtitle")
public class JobTitleController
{

    DepartmentService service;

    @PostMapping("/saves")
    ResponseEntity<String>  savedDepartments(@RequestBody List<Department> jobTitleList, @SessionAttribute Employee user ){
      if(jobTitleList.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("List cannot be empty");

      return ResponseEntity.ok(service.saves(jobTitleList));
    }


}