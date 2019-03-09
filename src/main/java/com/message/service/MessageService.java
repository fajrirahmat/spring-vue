package com.message.service;

import java.util.List;

import com.message.Message;

public interface MessageService {
	
	List<Message> getAll();
	
	Message save(Message message);
	
	void delete(int id);
}
