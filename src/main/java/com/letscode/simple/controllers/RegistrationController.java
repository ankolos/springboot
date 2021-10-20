package com.letscode.simple.controllers;

import com.letscode.simple.models.Role;
import com.letscode.simple.models.User;
import com.letscode.simple.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User userModel){
        userModel.setActive(true);
        userModel.setRoles(Collections.singleton(Role.USER));
        userRepository.save(userModel);

	return "redirect:/login";
    }
}
