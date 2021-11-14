package com.bridgelabz.employeepayrollapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

/**
 * Throw exception message to  client
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */

@ControllerAdvice
public class EmployeePayrollExceptionHandler {
	
	 /**
     * Function to Handle MethodArgumentNotValidException exception.
     *
     * @return throw to the  response entity it is a bad request.
     */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception While Processing REST Request", errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);

	}

	 /**
     * Function to handle Employeepayroll exception.
     *
     * @return Throw custom message
     */
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmpPayrollException(EmployeePayrollException exception) {
		ResponseDTO responseDto = new ResponseDTO("Exception while processing REST Request", exception.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
	}

	 /**
     * Function to handle HttpMessageNotReadableException
     *
     * @return throw not readable exception message to response entity 
     */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		ResponseDTO responseDto = new ResponseDTO("Exception while processing REST Request",
				"Invalid Input Provided!!!");
		return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
	}
}
