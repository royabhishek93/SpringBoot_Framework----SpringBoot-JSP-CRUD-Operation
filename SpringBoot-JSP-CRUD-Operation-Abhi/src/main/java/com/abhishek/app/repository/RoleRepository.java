package com.abhishek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
