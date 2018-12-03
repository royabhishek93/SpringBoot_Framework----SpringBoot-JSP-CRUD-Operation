package com.abhishek.app.service;

import java.util.List;

import com.abhishek.app.model.Address;


public interface AddressService {

	List<Address> addressList();
	
	Address addAddress(Address address);
	
	Address findOne(Long id);
	
	String deleteAddress(Long id);
}
