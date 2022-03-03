package com.suth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.suth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{id}")
    public String sendUser(@PathVariable int id) throws JsonProcessingException {
        return userService.sendUser(id);
    }

    @GetMapping(value = "/user")
    public void sendUsers() throws JsonProcessingException {
        userService.sendData();
    }
}
