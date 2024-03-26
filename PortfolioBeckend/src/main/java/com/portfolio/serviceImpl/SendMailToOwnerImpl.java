package com.portfolio.serviceImpl;

import org.springframework.stereotype.Service;

import com.portfolio.entities.ContactMe;
import com.portfolio.service.SendMailToOwner;

@Service
public class SendMailToOwnerImpl implements SendMailToOwner {

	@Override
	public boolean sendMail(ContactMe contactDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}
