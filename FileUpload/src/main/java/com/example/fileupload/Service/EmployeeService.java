package com.example.fileupload.Service;

import com.example.fileupload.Entity.Employee;
import com.example.fileupload.Repository.EmployeeRepo;
import com.example.fileupload.dto.EmployeResDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo emprepo;

    public String saveAll(List<Employee> employees) {

        System.out.println("JobTitile "+employees.get(0).getDepartments().get(0).getJobTitle());
        emprepo.saveAll(employees);
        return "Successfully saved";
    }

    public  List<Employee> findByDepartment(String dept) {

//        boolean departmentExists = emprepo.existsByJobTitle(dept);
//
//        if(!departmentExists){
//            throw new DeptNotFoundException("No job title found with title: " + dept);
//        }
//        return emprepo.findByJobTitleIgnoreCase(dept);

    	
        return null;
    }

	public EmployeResDTO getEmployee(Long id) {
		EmployeResDTO dto=emprepo.findEmployeeById(id);
		
		if(dto==null) throw new RuntimeException("Employee is not registred");
		return dto;
	}
	
	public Employee getEmployeeDepartment(Long id){
//		return emprepo.findByDepartmentsId(id);
		return emprepo.findByEmployeesId(id);
	}

	public List<Employee> employeesWith(String dept) {
		return emprepo.findByDepartmentsJobTitle(dept);
	}
    
}