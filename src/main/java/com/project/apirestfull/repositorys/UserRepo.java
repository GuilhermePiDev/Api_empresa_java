package com.project.apirestfull.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apirestfull.models.UserModel;

public interface UserRepo extends JpaRepository<UserModel , Integer>{
	

}
