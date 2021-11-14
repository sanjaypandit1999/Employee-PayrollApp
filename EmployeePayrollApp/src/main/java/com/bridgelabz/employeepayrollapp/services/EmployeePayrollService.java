package com.bridgelabz.employeepayrollapp.services;

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

/**
 * Layer contains business logic, also implements all the method in controller
 * layer
 *
 * @author Sanjay PAndit
 * @version 0.0.1
 * @since 10/11/2021
 */

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	EmployeePayrollRepository employeePayrollRepository;

	@Autowired
	TokenUtil tokenUtil;

	/**
	 * Function to get the list of all employee stored in DB
	 *
	 * @return all employee payroll Data from repository
	 */
	public List<EmployeePayrollData> getAllEmployeeData() {
		return employeePayrollRepository.findAll();
	}

	/**
	 * Function to get a particular employee data object stored in DB
	 *
	 * @param empId unique Id of employee
	 * @return employee payroll data object
	 */
	public EmployeePayrollData getEmployeeDataById(int empId) {
		return employeePayrollRepository.findById(empId)
				.orElseThrow(() -> new EmployeePayrollException("Employee ID:- " + empId + " Not Found"));
	}

	/**
	 * Function to get a particular employee data object stored in DB by using
	 * department
	 *
	 * @param department of employee
	 * @return employee payroll data object
	 */
	@Override
	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department) {
		return employeePayrollRepository.findEmployeesByDepartment(department);
	}

	/**
	 * Function to create employee payroll data object. This function maps employee
	 * dto object into employee entity object and then store it into DB
	 *
	 * @param empPayrollDto employee payroll data from clint
	 * @return employee payroll data created by this layer
	 */
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData ePayrollData = null;
		ePayrollData = new EmployeePayrollData(employeeDTO);
		log.debug("Emp Name: " + ePayrollData.toString());
		employeePayrollRepository.save(ePayrollData);
		return ePayrollData;
	}

	/**
	 * Function to update stored employee payroll data object. This function maps
	 * updated field of employee dto object into employee entity object and then
	 * store updated object into DB
	 *
	 * @param JWT           token of employee
	 * @param empPayrollDTO employee payroll data from clint
	 * @return employee payroll data updated by this layer
	 */
	public EmployeePayrollData updateEmployeePayrollData(String token, EmployeePayrollDTO employeeDTO) {
		Integer Id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(Id);
		if (empData.isPresent()) {
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

	/**
	 * Function to get particular entity object from DB and remove/delete it.
	 *
	 * @param JWT unique token
	 * @return String message containing status of operation
	 */
	public String deleteEmployeePayrollData(String token) {
		Integer Id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(Id);
		if (empData.isPresent()) {
			employeePayrollRepository.delete(empData.get());
			return "Dleted successfully";
		}

		return null;
	}

	/**
	 * Function to get all employee payroll entity object from DB.
	 *
	 * @param JWT unique token
	 * @return all employee payroll data object
	 */
	@Override
	public List<EmployeePayrollData> getAllEmployeeData(String token) {
		Integer Id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(Id);
		if (empData.isPresent()) {
			return employeePayrollRepository.findAll();
		}
		return null;
	}
}
