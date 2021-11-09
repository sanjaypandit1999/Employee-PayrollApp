package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	  public List<EmployeePayrollData> getAllEmployeeData() {
		  List<EmployeePayrollData> empDataList = new ArrayList<>();
		  empDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO( "Sanjay", 2000)));
	        return empDataList;
	    }

	    public EmployeePayrollData getEmployeeDataById(int empId) {
	    	EmployeePayrollData ePayrollData = null;
			ePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO( "Sanjay", 2000));
	        return ePayrollData;
	    }

	    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
	    	EmployeePayrollData ePayrollData = null;
			ePayrollData = new EmployeePayrollData(1, employeeDTO);
	        return ePayrollData;
	    }

	    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeeDTO) {
	    	EmployeePayrollData ePayrollData = null;
			ePayrollData = new EmployeePayrollData(1, employeeDTO);
	        return ePayrollData;
	    }

	    public EmployeePayrollData deleteEmployeePayrollData(int empId) {
	        return null;
	    }

}
