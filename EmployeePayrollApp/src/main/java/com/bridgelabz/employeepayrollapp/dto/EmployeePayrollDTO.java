package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name is invalid")
	@NotEmpty
	public String empName;
	@Min(value = 500, message = "Min Wage should be more than 500")
	public long salary;

	public EmployeePayrollDTO(String empName, long salary) {
		super();
		this.empName = empName;
		this.salary = salary;
	}

}
