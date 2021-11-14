package com.bridgelabz.employeepayrollapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

/**
 * Store employee data in Jpa repository
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

	/**
	 * Function to get particular token of employee id
	 *
	 * @query to receive employee payroll data object from DB
	 * @param employee department
	 * @return JWT token
	 */
	@Query(value = "select * from employeepayroll_db,employee_department where employee_id=id and departments= :department", nativeQuery = true)
	List<EmployeePayrollData> findEmployeesByDepartment(String department);

}
