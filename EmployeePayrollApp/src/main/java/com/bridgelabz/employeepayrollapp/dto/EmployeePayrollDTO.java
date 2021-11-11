package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;
@ToString
public class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name is invalid")
	@NotEmpty
	public String empName;
	
	@Pattern(regexp = "male|female", message = "Gender needs to be male or female")
	public String gender;
	
	@NotNull(message = "Date can not be empty, put date in DD-MM-YYYY format")
	@JsonFormat(pattern = "dd MM yyyy")
	@PastOrPresent(message = "This is Future date!!!")
	public LocalDate startDate;

	@NotNull(message = "Department should not be empty")
	public List<String> departments;
	
	@Min(value = 500, message = "Min Wage should be more than 500")
	public long salary;
	
	@NotBlank(message = "Select a Profile picture")
	public String profilePic;

	@NotBlank(message = "Note cannot be empty")
	public String note;

}
