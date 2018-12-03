package com.abhishek.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abhishek.app.model.Role;
import com.abhishek.app.model.User;


public interface UserService {
	List<User> userList();
	User findOne(Long id);
	User addUser(User user);
	String deleteUser(Long id);
	List<Role> roleList();
}
