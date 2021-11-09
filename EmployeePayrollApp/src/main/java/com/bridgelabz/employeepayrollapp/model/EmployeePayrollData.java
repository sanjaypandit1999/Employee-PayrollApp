package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

@Data
public class EmployeePayrollData {
	
	private int empId;
	private String empName;
	private long salary;
	
	public EmployeePayrollData(int empId, EmployeePayrollDTO ePayrollDTO) {
		super();
		this.empId = empId;
		this.empName = ePayrollDTO.empName;
		this.salary = ePayrollDTO.salary;
	}
}
