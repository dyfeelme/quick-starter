package com.zs.framework.nutz.service;

public interface EmailService {

	boolean send(String to, String subject, String html);
	
}
