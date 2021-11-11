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
		return empDataList;
	}

	public EmployeePayrollData getEmployeeDataById(int empId) {
		return empDataList.stream().filter(empData -> empData.getEmployeeId() == empId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee ID Not Found"));
	}

	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = new EmployeePayrollData(employeeDTO);
		empDataList.add(ePayrollData);
		log.debug("Emp Name: " +ePayrollData.toString());
		employeePayrollRepository.save(ePayrollData);
		return ePayrollData;
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData ePayrollData = this.getEmployeeDataById(empId);
		ePayrollData.setName(employeeDTO.empName);
		ePayrollData.setSalary(employeeDTO.salary);
		empDataList.set(empId - 1, ePayrollData);
		return ePayrollData;
	}

	public EmployeePayrollData deleteEmployeePayrollData(int empId) {
		return empDataList.remove(empId - 1);
	}

}
