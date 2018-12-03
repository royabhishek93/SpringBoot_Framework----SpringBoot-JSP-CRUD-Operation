package com.abhishek.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.app.service.AddressService;
import com.abhishek.app.service.UserService;
import com.abhishek.app.model.Address;
import com.abhishek.app.model.User;


@Controller
@RequestMapping("/address")
public class AddressController {
	
	private AddressService  addressService;
	private UserService  userService;

	@Autowired
	public AddressController(AddressService addressService,UserService  userService) {
		this.userService=userService;
		this.addressService = addressService;
	}
	
	@GetMapping("/form")
	public String addressForm(Model model ) {
		model.addAttribute("addressForm", new Address());
		model.addAttribute("users",userService.userList());
		return "/address/form";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editAddress(@PathVariable Long id,Model model ) {
		model.addAttribute("addressForm", addressService.findOne(id));
		model.addAttribute("users", userService.userList() );
		return "/address/form";
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String addressList(Model model){
	 model.addAttribute("addresses", addressService.addressList());
	 return "/address/list";
	//return addressService.addressList();
	}
	
	@GetMapping("/list/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Address findOne(@PathVariable Long id) {
		return addressService.findOne(id);
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String addAddress(@ModelAttribute Address address,Model model) {
		String message="";
		if(address.getId()==null) {
			message=" added";
		}
		else {
			message=" updated";
		}
		model.addAttribute("message",addressService.addAddress(address).getUser().getUserName()+" address "+message+" successfully" ); 
		return "message";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Long id,Model model) {
		model.addAttribute("message", addressService.deleteAddress(id));
		return "message";
		
	}
	
	

}
