package com.vaccination.notify.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vaccination.notify.bean.MessageObject;

@Service
public class MessageService {

	@Value("${twilio.account.sid}")
	private String ACCOUNT_SID;

	@Value("${twilio.account.token}")
	private String AUTH_TOKEN;

	@Value("${twilio.msg.sender}")
	private String SENDER;

	private Logger logger = LoggerFactory.getLogger(MessageService.class);

	public void sendMessage(MessageObject msgObj) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message.creator(new PhoneNumber(msgObj.getToSender()), new PhoneNumber(SENDER), msgObj.getMessage()).create();

		logger.info("Sending msg to : {} and the message is : {} ", msgObj.getToSender(), msgObj.getMessage());
	}
}
