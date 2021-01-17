package com.hcl.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecart.dto.UserUpdateDto;

import com.hcl.ecart.entity.UserEntity;
import com.hcl.ecart.repository.UserRepo;
import com.hcl.ecart.service.IAdminService;

@RestController
public class AdminController {
	@Autowired
	IAdminService service;
	@Autowired
	UserRepo userRepo;

	@PutMapping("/viewUpdateUser/{email_id}")
	public ResponseEntity<UserEntity> viewUpdateUser(@PathVariable String email_id,
			@RequestBody UserUpdateDto userUpdateDto) {		
		service.viewUpdateUser(email_id, userUpdateDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
