package com.bridgelabz.employeepayrollapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import com.bridgelabz.employeepayrollapp.util.TokenUtil;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	IEmployeePayrollService iEmployeePayrollService;
	
	@Autowired
	TokenUtil tokenUtil;

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@RequestHeader (name="token") String token) {
		List<EmployeePayrollData> empDataList = null;
		empDataList = iEmployeePayrollService.getAllEmployeeData(token);
		ResponseDTO responseDTO = new ResponseDTO("Get call SUccess", empDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable int empId) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = iEmployeePayrollService.getEmployeeDataById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Get call for id Success", ePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String department) {

		List<EmployeePayrollData> employeeList = null;
		employeeList = iEmployeePayrollService.getEmployeesPayrollDataByDepartment(department);
		ResponseDTO response = new ResponseDTO("Get Call for Department Successful", employeeList);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeeDto) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = iEmployeePayrollService.addEmployeePayrollData(employeeDto);
		ResponseDTO responseDTO = new ResponseDTO("Create Employeepayroll Data Successfully", tokenUtil.createToken(ePayrollData.getEmployeeId()));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestHeader (name="token") String token,
			@Valid @RequestBody EmployeePayrollDTO employeeDto) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = iEmployeePayrollService.updateEmployeePayrollData(token, employeeDto);
		ResponseDTO responseDTO = new ResponseDTO("Update Employeepayroll Data Successfully", ePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@RequestHeader (name="token") String token) {
		iEmployeePayrollService.deleteEmployeePayrollData(token);
		ResponseDTO responseDTO = new ResponseDTO(" Deleted Successfully", "It is updated to database " );
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
