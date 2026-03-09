package com.example.fileupload.Controller;

import com.example.fileupload.Entity.Department;
import com.example.fileupload.Exceptions.DeptNotFoundException;
import com.example.fileupload.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

	@Autowired
	DepartmentService depservice;

	@PostMapping("/saves")
	public ResponseEntity<String> saveDepartments(@RequestBody List<Department> departments ){

//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deployee should not be depty");

		return ResponseEntity.ok(null);
	}


	@GetMapping("/getDepartments")
	public ResponseEntity<?> getSpecifieddepartments(@RequestParam List<String> depts ){

//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Names Should not be depty");
		return ResponseEntity.ok().body(null);
	}

	@GetMapping("Departments/{dept}")
	ResponseEntity<?> getByDepartment(@PathVariable String dept){

//		List<Employee> departments = depservice.findByDepartment(dept);

//		if(departments.isdepty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record found on this dept");

		return ResponseEntity.ok().body(null);
	}


	@ExceptionHandler(DeptNotFoundException.class)
	ResponseEntity<String> handleDepNotFoundException(DeptNotFoundException ex){

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}