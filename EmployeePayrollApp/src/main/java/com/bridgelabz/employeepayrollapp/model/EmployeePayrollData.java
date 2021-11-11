package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeePayrollData {

	private int empId;
	private String empName;
	private String gender;
	private List<String> departments;
	private LocalDate startDate;
	private long salary;
	private String profilePic;
	private String note;

}
