package com.apt.truyenmvc.service;

import com.apt.truyenmvc.entity.custom.Mail;

/**
 * @author Huy Thang
 *
 */
public interface EmailService {

	public boolean sendSimpleMessage(Mail mail);
	
}
