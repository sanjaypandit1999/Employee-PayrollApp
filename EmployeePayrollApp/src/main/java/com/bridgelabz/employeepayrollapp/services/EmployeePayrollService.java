package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	EmployeePayrollRepository employeePayrollRepository;
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

	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData ePayrollData = this.getEmployeeDataById(empId);
		ePayrollData.updateEmployeePayollData(employeeDTO);
		employeePayrollRepository.save(ePayrollData);
		return ePayrollData;
	}

	public EmployeePayrollData deleteEmployeePayrollData(int empId) {
		EmployeePayrollData ePayrollData = this.getEmployeeDataById(empId);
		employeePayrollRepository.delete(ePayrollData);
		return ePayrollData;
	}

}
