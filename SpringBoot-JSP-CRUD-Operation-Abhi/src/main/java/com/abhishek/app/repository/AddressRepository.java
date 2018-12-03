package com.abhishek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.app.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
