package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
/**
 * Create and maintains response data in object.
 * class contains a message field and a general field for any type of data
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */
@Data
public class ResponseDTO {
	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

}
