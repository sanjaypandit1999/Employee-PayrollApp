package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public interface IEmployeePayrollService {
	public List<EmployeePayrollData> getAllEmployeeData();

	public EmployeePayrollData getEmployeeDataById(int empId);

	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO);

	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeeDTO);

	public EmployeePayrollData deleteEmployeePayrollData(int empId);
	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department);

}
