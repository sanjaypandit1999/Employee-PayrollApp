package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
	
	private int empId;
	private String empName;
	private long salary;

	public EmployeePayrollData() {

	}

	public EmployeePayrollData(int empId, EmployeePayrollDTO ePayrollDTO) {
		super();
		this.empId = empId;
		this.empName = ePayrollDTO.empName;
		this.salary = ePayrollDTO.salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
