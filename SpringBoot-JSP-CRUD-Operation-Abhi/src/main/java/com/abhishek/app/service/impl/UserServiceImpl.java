package com.abhishek.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.app.model.Role;
import com.abhishek.app.model.User;
import com.abhishek.app.repository.RoleRepository;
import com.abhishek.app.repository.UserRepository;
import com.abhishek.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository) {
		this.userRepository=userRepository;
		this.roleRepository=roleRepository;
	}
	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setRole(roleRepository.findById(user.getRole().getId()).orElse(null));
		return userRepository.save(user);
	}
	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		 userRepository.deleteById(id);
		return " User deleted successfully ";
		
	}
	@Override
	public List<Role> roleList() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
