package com.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.message.aop.SecurityCheck;
import com.message.dto.MessageDto;
import com.message.service.MessageService;

@Controller
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping(value = "/welcome")
	public String welcome(Model model) {
		model.addAttribute("message", "Hello World");
		return "welcome";
	}
	
	@GetMapping("")
	@ResponseBody
	public ResponseEntity<List<Message>> getAll(){
		return new ResponseEntity<List<Message>>(messageService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("")
	@ResponseBody
	@SecurityCheck
	public ResponseEntity<Message> saveMessage(@RequestBody MessageDto message){
		return new ResponseEntity<Message>(messageService.save(new Message(message.getText())), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteMessage(@PathVariable(name = "id") int id){
		messageService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
