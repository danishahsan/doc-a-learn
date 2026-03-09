package com.example.fileupload.Repository;

import com.example.fileupload.Entity.Employee;
import com.example.fileupload.dto.EmployeResDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {


//    Optional<Employee> findById(Long id);
//    List<Employee> findByJobTitleIgnoreCase(String title);

//    boolean existsByJobTitle(String title); ,d.jobTitle
    @Query(""" 
    		select  new com.example.fileupload.dto.
    		EmployeResDTO(e.id,e.firstName,e.lastName,e.email,e.gender)
    		
    		from Employee e
    		
    		left join e.departments d
    		where e.id=:id
    		""")
    EmployeResDTO findEmployeeById(Long id);
    
    Employee findByDepartmentsId(Long id);
    
    List<Employee> findByDepartmentsJobTitle(String jobTitle);
    
    @Query("select e from Employee e LEFT JOIN FETCH e.departments where e.id= :i")
    Employee findByEmployeesId(Long i);
}
