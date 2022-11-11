package com.springblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springblog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
