package com.abhishek.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController {

	public static final String PATH="/error";
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

	@RequestMapping(PATH)
	public String error() {
		return "No Mapping Available";
	}
}
