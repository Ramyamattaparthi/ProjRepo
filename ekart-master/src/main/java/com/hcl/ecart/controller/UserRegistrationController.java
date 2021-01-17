package com.hcl.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecart.dto.UserLoginDto;
import com.hcl.ecart.dto.UserLoginResponseDto;
import com.hcl.ecart.dto.UserRequestDto;
import com.hcl.ecart.dto.UserResponseDto;
import com.hcl.ecart.service.UserService;
import com.hcl.ecart.service.UserServiceImpl;

@RestController
public class UserRegistrationController {  
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value ="/custom", method = RequestMethod.POST)
	public String user() {
		return "login success";
	}
	
	@PostMapping("/userReg")
	public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto) {
		UserResponseDto userResponseDto = userService.addUser(userRequestDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
	}
	@PutMapping("/users/login")
	public ResponseEntity<UserLoginResponseDto> userLogin(@RequestBody UserLoginDto userLoginDto) {
		UserLoginResponseDto userLoginResponseDto = userService.userLogin(userLoginDto);
		return new ResponseEntity<>(userLoginResponseDto, HttpStatus.CREATED);
	}

}
