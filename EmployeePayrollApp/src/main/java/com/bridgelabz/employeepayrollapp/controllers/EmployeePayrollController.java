package com.bridgelabz.employeepayrollapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<String> getEmployeePayrollData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeeDataById(@PathVariable int empId) {
		return new ResponseEntity<String>("Get call Succeed for id : " + empId, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<String>("created Employee Payroll Data for : " + employeeDto.toString(), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<String>("updated Employee Payroll Data for : " + employeeDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
		return new ResponseEntity<String>("deleted Employee Payroll Data for : " + empId, HttpStatus.OK);
	}

}
