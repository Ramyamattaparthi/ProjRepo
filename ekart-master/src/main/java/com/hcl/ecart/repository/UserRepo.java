package com.hcl.ecart.repository;








import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecart.entity.UserEntity;
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByMobile(Long mobile);
	UserEntity findByEmailId(String emailId);
	public List<UserEntity> findByUserName(String userName);
}
