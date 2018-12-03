package com.abhishek.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.app.model.Address;
import com.abhishek.app.repository.AddressRepository;
import com.abhishek.app.repository.UserRepository;
import com.abhishek.app.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository  addressRepository;
	private UserRepository  userRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository,UserRepository  userRepository) {
		
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		// TODO Auto-generated method stub
		
		return addressRepository.findAll();
	}

	@Override
	public Address addAddress(Address address) {
		
		// TODO Auto-generated method stub
		 address.setUser(userRepository.findById(address.getUser().getId()).orElse(null));
			
		 return addressRepository.save(address);
	}

	@Override
	public Address findOne(Long id) {
		// TODO Auto-generated method stub
		 return addressRepository.findById(id).orElse(null);
	}

	@Override
	public String deleteAddress(Long id) {
		// TODO Auto-generated method stub
		  addressRepository.deleteById(id);
		return " Address deleted successfully ";
	}
	

}
