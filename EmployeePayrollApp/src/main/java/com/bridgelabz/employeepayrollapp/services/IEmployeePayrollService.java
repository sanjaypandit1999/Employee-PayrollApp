package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

/**
 * Interface of service layer
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */
@Service
public interface IEmployeePayrollService {

	public EmployeePayrollData getEmployeeDataById(int empId);

	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO);

	public EmployeePayrollData updateEmployeePayrollData(String token, EmployeePayrollDTO employeeDTO);

	public String deleteEmployeePayrollData(String token);

	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department);

	public List<EmployeePayrollData> getAllEmployeeData(String token);

	public List<EmployeePayrollData> getAllEmployeeData();

}
