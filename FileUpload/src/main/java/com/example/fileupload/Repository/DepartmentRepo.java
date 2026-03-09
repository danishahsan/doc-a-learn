package com.example.fileupload.Repository;

import com.example.fileupload.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
	
	Department findByEmployeeId(Long id);
}
