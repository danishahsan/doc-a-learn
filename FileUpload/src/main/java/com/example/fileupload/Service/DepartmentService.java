package com.example.fileupload.Service;

import com.example.fileupload.Entity.Department;
import com.example.fileupload.Repository.DepartmentRepo;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    DepartmentRepo jsRepo;

    public String saves(List<Department> jobTitleList) {

        jsRepo.saveAll(jobTitleList);

        return "Jobtitles saved successfully";
    }
    
    
    public void getEmployee() {
		// TODO Auto-generated method stub

	}
}
