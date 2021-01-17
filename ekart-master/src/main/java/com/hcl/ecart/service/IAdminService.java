package com.hcl.ecart.service;

import com.hcl.ecart.dto.UserUpdateDto;
import com.hcl.ecart.entity.UserEntity;

public interface IAdminService {

	public UserEntity viewUpdateUser(String email_id, UserUpdateDto userUpdateDto);
}
