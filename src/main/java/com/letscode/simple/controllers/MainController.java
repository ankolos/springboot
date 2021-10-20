package com.letscode.simple.controllers;

import com.letscode.simple.models.Message;
import com.letscode.simple.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String home(Model model) {
	return "home";
    }

    @GetMapping("/message")
    public String message(Model model) {
	Iterable<Message> messages = messageRepository.findAll();
	model.addAttribute("messages", messages);

	return "message";
    }

    @PostMapping("/message")
    public String addMessage(@RequestParam String text, @RequestParam String tag) {
	Message message = new Message(text, tag);
	messageRepository.save(message);

	return "redirect:/message";
    }

    @PostMapping("/message/filter")
    public String  filterMessage(@RequestParam String filter, Model model) {
	Iterable<Message> messages;

	if (filter != null && !filter.isEmpty()) {
	    messages = messageRepository.findByTag(filter);
	} else {
	    messages = messageRepository.findAll();
	}
	model.addAttribute("messages", messages);

	return "message";
    }

    @GetMapping("message/delete/{id}")
    public String home(@PathVariable(value = "id") long id) {
	messageRepository.deleteById(id);

	return "redirect:/message";
    }

}
