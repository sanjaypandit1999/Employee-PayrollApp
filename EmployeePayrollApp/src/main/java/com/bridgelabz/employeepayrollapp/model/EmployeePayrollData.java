package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

/**
 * Create and maintains employee payroll data in object.
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */

@Entity
@Table(name = "employeepayroll_db")
@Data
public class EmployeePayrollData {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "employee_id")
	    private int employeeId;
	    @Column(name = "name")
	    private String name;
	    @Column(name = "salary")
	    private long salary;
	    @Column(name = "gender")
	    private String gender;
	    @Column(name = "start_date")
	    private LocalDate startDate;
	    @Column(name = "note")
	    private String note;
	    @Column(name = "profile_pic")
	    private String profilePic;

	    @ElementCollection
	    @CollectionTable(name = "employee_department",
	            joinColumns = @JoinColumn(name ="id"))
	    @Column(name = "departments")
	    private List<String> departments;
	    
	    public EmployeePayrollData() {
	    }
	    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
	        this.updateEmployeePayollData(employeePayrollDTO);
	    }

	    public void updateEmployeePayollData( EmployeePayrollDTO employeePayrollDTO) {
	        this.name = employeePayrollDTO.empName;
	        this.salary = employeePayrollDTO.salary;
	        this.gender = employeePayrollDTO.gender;
	        this.note = employeePayrollDTO.note;
	        this.startDate = employeePayrollDTO.startDate;
	        this.profilePic = employeePayrollDTO.profilePic;
	        this.departments = employeePayrollDTO.departments;
	    
	    }


}
