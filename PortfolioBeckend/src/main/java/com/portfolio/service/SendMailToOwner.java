package com.portfolio.service;

import com.portfolio.entities.ContactMe;

public interface SendMailToOwner {

	public boolean sendMail(ContactMe contactDetails);
}
