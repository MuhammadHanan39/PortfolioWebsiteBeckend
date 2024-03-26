package com.portfolio.entities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entities.ContactMe;
import com.portfolio.serviceImpl.SendMailToOwnerImpl;

@RestController
public class ContactMeController {

	@Autowired
	private SendMailToOwnerImpl sendMailToOwnerImpl;
	
	@PostMapping("/contact")
	public ResponseEntity<String> contactHandler(@PathVariable ContactMe contact){
		
		
		this.sendMailToOwnerImpl.sendMail(contact);
		return new ResponseEntity<String>("Mail Sends Successfully",HttpStatus.OK);
	}
	
	
	
	
	
	
}
