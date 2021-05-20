package com.vaccination.notify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccination.notify.bean.MessageObject;
import com.vaccination.notify.service.MessageService;

@RestController
@RequestMapping(value = "/v1")
public class MessageController {
	
	@Autowired
	MessageService service;
	
	@PostMapping("/sendMessage")
	public String sendMessage(@RequestBody MessageObject messageObject) {
		service.sendMessage(messageObject);
		return "Wolla! My goodness";
	}

}
