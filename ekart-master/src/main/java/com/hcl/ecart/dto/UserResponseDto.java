package com.hcl.ecart.dto;

import org.springframework.stereotype.Component;

@Component
public class UserResponseDto {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	private Integer statusCode;
	
	
	

}
