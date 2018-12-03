package com.abhishek.app.schedular;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.abhishek.app.aspect.LoggerAspect;
import com.abhishek.app.service.AddressService;
import com.abhishek.app.service.UserService;

@Component
public class JobSchedular {
 
	private static Logger logger= LogManager.getLogger(JobSchedular.class);
	private  UserService userService;
	private  AddressService addressService;
	
	
	@Autowired	
	public JobSchedular(UserService userService,AddressService addressService) {
		
		this.userService = userService;
		this.addressService = addressService;
	}
	//@Scheduled(cron="*/5 * * * * *")
	public void scheduleUsingCron() {
		logger.info(userService.userList());
	}
	//@Scheduled(fixedDelay=1000, initialDelay=1000)
	public void scheduleUsingFixedDelayWithInitialDelay() {
		logger.info(userService.findOne(1L));
	}
	
	//@Scheduled(fixedDelay=1000)
	public void scheduleUsingDelay() {
		logger.info(addressService.addressList());
	}
	
	//@Scheduled(fixedRate=5000)
	public void scheduleUsingRate() {
		logger.info(addressService.findOne(1L));
	}
}
