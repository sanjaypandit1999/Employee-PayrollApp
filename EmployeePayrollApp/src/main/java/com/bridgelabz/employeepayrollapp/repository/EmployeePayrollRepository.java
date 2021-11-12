package com.bridgelabz.employeepayrollapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
	@Query(value = "select * from employeepayroll_db,employee_department where employee_id=id and departments= :department", nativeQuery = true)
	List<EmployeePayrollData> findEmployeesByDepartment(String department);

}
