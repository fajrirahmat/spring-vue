package com.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.Message;
import com.message.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public Message save(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public void delete(int id) {
		Message message = messageRepository.findById(id).get();
		if(message == null) {
			throw new RuntimeException("Message not found with id: " + id);
		}
		messageRepository.delete(message);
	}

	@Override
	public List<Message> getAll() {
		return (List<Message>) messageRepository.findAll();
	}

}
