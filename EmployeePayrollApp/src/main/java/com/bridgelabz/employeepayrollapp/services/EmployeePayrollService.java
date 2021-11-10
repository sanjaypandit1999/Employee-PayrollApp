package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	List<EmployeePayrollData> empDataList = new ArrayList<>();

	public List<EmployeePayrollData> getAllEmployeeData() {
		return empDataList;
	}

	public EmployeePayrollData getEmployeeDataById(int empId) {
		return empDataList.stream().filter(empData -> empData.getEmpId() == empId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee ID Not Found"));
	}

	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = new EmployeePayrollData(empDataList.size() + 1, employeeDTO);
		empDataList.add(ePayrollData);
		return ePayrollData;
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData ePayrollData = this.getEmployeeDataById(empId);
		ePayrollData.setEmpName(employeeDTO.empName);
		ePayrollData.setSalary(employeeDTO.salary);
		empDataList.set(empId - 1, ePayrollData);
		return ePayrollData;
	}

	public EmployeePayrollData deleteEmployeePayrollData(int empId) {
		return empDataList.remove(empId - 1);
	}

}
