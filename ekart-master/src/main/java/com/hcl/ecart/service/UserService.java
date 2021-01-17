package com.hcl.ecart.service;

import com.hcl.ecart.dto.UserLoginDto;
import com.hcl.ecart.dto.UserLoginResponseDto;
import com.hcl.ecart.dto.UserRequestDto;
import com.hcl.ecart.dto.UserResponseDto;

public interface UserService {
	
	public UserResponseDto addUser(UserRequestDto userRequestDto);
	
	public UserLoginResponseDto userLogin(UserLoginDto userLoginDto);

}
