package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Main Method of Employee PAyroll App
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("Employee Payroll App Started in {} Enviroment", context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB User is {}", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
