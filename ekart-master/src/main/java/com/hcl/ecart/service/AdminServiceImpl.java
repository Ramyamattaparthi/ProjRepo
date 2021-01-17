package com.hcl.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecart.dto.UserResponseDto;
import com.hcl.ecart.dto.UserUpdateDto;
import com.hcl.ecart.entity.UserEntity;
import com.hcl.ecart.exception.UserException;
import com.hcl.ecart.repository.UserRepo;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	UserRepo userRepo;

	public UserEntity viewUpdateUser(String email_id, UserUpdateDto userUpdateDto) {
		UserEntity db = userRepo.findByEmailId(email_id);
		UserResponseDto userResponseDto = new UserResponseDto();
		if (db != null) {
			if (db.getRole().getRoleId() == 2 || db.getRole().getRoleId() == 3) {
				db.setAddress(userUpdateDto.getAddress());
				db.setPassword(userUpdateDto.getPassword());
				db.setUserName(userUpdateDto.getUserName());
				userRepo.save(db);
			} else {

				throw new UserException("You can't edit Admin user");
			}
		} else if (db == null || db.getEmailId().isEmpty()) {
			throw new UserException("Provide a valid email address");
		}
		return db;
	}

}
