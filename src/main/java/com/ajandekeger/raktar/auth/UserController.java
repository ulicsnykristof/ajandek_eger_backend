package com.ajandekeger.raktar.auth;

import com.ajandekeger.raktar.termek.Termek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @CrossOrigin
    @GetMapping(path="/alluser")
    public @ResponseBody Iterable<Users> getAllUser(){

        return userRepository.findAll();
    }

}
