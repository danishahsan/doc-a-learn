package com.example.fileupload.Controller;

import com.example.fileupload.Entity.Employee;
import com.example.fileupload.Exceptions.DeptNotFoundException;
import com.example.fileupload.Service.EmployeeService;
import com.example.fileupload.dto.EmployeResDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@PostMapping("/saves")
	public ResponseEntity<String> saveEmpolyees(@RequestBody List<Employee> employees ){

		if(employees.isEmpty()){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("employee should not be empty");
		}

		return ResponseEntity.ok(empService.saveAll(employees));
	}


	@GetMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees(@RequestParam List<String> depts ){

		if(depts.isEmpty()){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("names should not be Empty");
		}
		return ResponseEntity.ok().body(empService.findByDepartment(null));
	}

	@GetMapping("/{id}")
	ResponseEntity<EmployeResDTO> getAEmployee(@PathVariable Long id){

		EmployeResDTO employee= empService.getEmployee(id);

		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping("/dept/{id}")
	ResponseEntity<Employee> EmployeeWithDepartment(@PathVariable Long id){

		Employee employee= empService.getEmployeeDepartment(id);
		System.err.println(employee);
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping("/job/{dept}")
	ResponseEntity<List<Employee>> EmployeeWithJobTitle(@PathVariable String dept){

		List<Employee> employees= empService.employeesWith(dept);
		return ResponseEntity.ok().body(employees);
	}


	@ExceptionHandler(DeptNotFoundException.class)
	ResponseEntity<String> handleDepNotFoundException(DeptNotFoundException ex){

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}