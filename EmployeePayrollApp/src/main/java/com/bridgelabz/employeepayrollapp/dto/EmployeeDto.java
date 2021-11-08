package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	private String empName;
	private long salary;
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
	public EmployeeDto(String empName, long salary) {
		super();
		this.empName = empName;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeePayrollDto [empName=" + empName + ", salary=" + salary + "]";
	}
	

}
