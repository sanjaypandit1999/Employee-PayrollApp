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

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO( "Sanjay", 2000));
		ResponseDTO responseDTO = new ResponseDTO("Get call SUccess", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable int empId) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO( "Sanjay", 2000));
		ResponseDTO responseDTO = new ResponseDTO("Get call for id Success", ePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDto) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = new EmployeePayrollData(1, employeeDto);
		ResponseDTO responseDTO = new ResponseDTO("Create Employeepayroll Data Successfully", ePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int empId ,@RequestBody EmployeePayrollDTO employeeDto) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = new EmployeePayrollData(1, employeeDto);
		ResponseDTO responseDTO = new ResponseDTO("Update Employeepayroll Data Successfully", ePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int empId) {
		ResponseDTO responseDTO = new ResponseDTO(" Deleted Successfully", "Delete Id: " +empId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
