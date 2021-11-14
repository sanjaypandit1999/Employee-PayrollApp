package com.bridgelabz.employeepayrollapp.exception;

/**
 * Throw custom exception message 
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */
public class EmployeePayrollException extends RuntimeException {
	
	  /**
     * Constructor to throw custom message to client
     *
     * @return throwable message
     */
	public EmployeePayrollException(String message) {
		super(message);
	}

}
