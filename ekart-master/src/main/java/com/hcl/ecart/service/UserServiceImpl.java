package com.hcl.ecart.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ecart.dto.UserLoginDto;
import com.hcl.ecart.dto.UserLoginResponseDto;
import com.hcl.ecart.dto.UserRequestDto;
import com.hcl.ecart.dto.UserResponseDto;
import com.hcl.ecart.entity.UserEntity;
import com.hcl.ecart.exception.UserException;
import com.hcl.ecart.repository.UserRepo;
import com.hcl.ecart.util.Validations;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRep;
	
	@Autowired
	UserResponseDto userResponseDto;
	
	@Override
	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		
		
		/*
		 * UserEntity
		 * userDetailsUserName=userRep.findByUserName(userRequestDto.getUserName());
		 * 
		 * if(userDetailsUserName!=null) throw new
		 * UserException("username alredy existed");
		 */
		
		
		
	UserEntity userDetailsMobile = userRep
				.findByMobile(userRequestDto.getMobile());
		if(userDetailsMobile!=null)
			throw new UserException("mobile alredy existed");

		if (!Validations.mobileValid(userRequestDto.getMobile() + ""))
			throw new UserException("Mobile number not valid");

	UserEntity userDetailsEmail = userRep
				.findByEmailId(userRequestDto.getEmailId());
	if(userDetailsEmail!=null)
		throw new UserException("emaild alredy existed");
		
	/*
	 * if(!EmailValidator.validateEmail(userRequestDto.getEmailId()+"")) throw new
	 * UserException("emailId not valid");
	 */
		
		UserEntity userEntity =new UserEntity();
		BeanUtils.copyProperties(userRequestDto, userEntity);
		userRep.save(userEntity);
		
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setMessage("Added successfully");
		userResponseDto.setStatusCode(HttpStatus.CREATED.value());
		return userResponseDto;
	}

	@Override
	public UserLoginResponseDto userLogin(UserLoginDto userLoginDto) {
		UserLoginResponseDto responseLogin = new UserLoginResponseDto();

		List<UserEntity> loginDetails = userRep.findByUserName(userLoginDto.getUserName());
		if(loginDetails.size()==0)
		{
			throw new UserException("no user found.");
		}
		
		for(UserEntity user:loginDetails)
		{
			if(user.getPassword().equals(userLoginDto.getPassword()))
			{
				responseLogin.setUserId(user.getUserId());
				responseLogin.setMessage("Login Successfully");
				responseLogin.setStatusCode(HttpStatus.CREATED.value());
				
			}
		
		}
		
		return responseLogin;
	}

}





