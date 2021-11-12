package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import com.bridgelabz.employeepayrollapp.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	EmployeePayrollRepository employeePayrollRepository;
	
	@Autowired
	TokenUtil tokenUtil;
	
	List<EmployeePayrollData> empDataList = new ArrayList<>();

	public List<EmployeePayrollData> getAllEmployeeData() {
		return employeePayrollRepository.findAll();
	}

	public EmployeePayrollData getEmployeeDataById(int empId) {
		return employeePayrollRepository.findById(empId)
				.orElseThrow(() -> new EmployeePayrollException("Employee ID:- " + empId + " Not Found"));
	}
	@Override
	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department) {
		return employeePayrollRepository.findEmployeesByDepartment(department);
	}


	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = new EmployeePayrollData(employeeDTO);
		log.debug("Emp Name: " + ePayrollData.toString());
		employeePayrollRepository.save(ePayrollData);
		return ePayrollData;
	}

	public EmployeePayrollData updateEmployeePayrollData(String token, EmployeePayrollDTO employeeDTO) {
		Integer Id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(Id);
		if(empData.isPresent()) {
			empData.get().setName(employeeDTO.empName);
			empData.get().setDepartments(employeeDTO.departments);
			empData.get().setGender(employeeDTO.gender);
			empData.get().setSalary(employeeDTO.salary);
			empData.get().setProfilePic(employeeDTO.profilePic);
			empData.get().setStartDate(employeeDTO.startDate);
			empData.get().setNote(employeeDTO.note); 
			employeePayrollRepository.save(empData.get());
			return empData.get();
		}	
		return null;
	}

	public String deleteEmployeePayrollData(String token) {
		Integer Id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(Id);
		if(empData.isPresent()) {
			employeePayrollRepository.delete(empData.get());	
		}
		
		return null;
	}

	@Override
	public List<EmployeePayrollData> getAllEmployeeData(String token) {
		Integer Id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(Id);
		if(empData.isPresent()) {
			return employeePayrollRepository.findAll();	
		}
		return null;
	}
}
