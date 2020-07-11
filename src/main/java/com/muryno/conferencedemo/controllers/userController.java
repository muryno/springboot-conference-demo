package com.muryno.conferencedemo.controllers;


import com.muryno.conferencedemo.models.session;
import com.muryno.conferencedemo.models.users;
import com.muryno.conferencedemo.repositories.sessionRepository;
import com.muryno.conferencedemo.repositories.usersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class userController {

    @Autowired
    private usersRepository sessionRepository;


    @RequestMapping("/a")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    @GetMapping
    public List<users> getSession() {
        List<users> userList = sessionRepository.findAll();
        System.out.println(userList);
        return userList;
    }

    @PostMapping("/add/users")
    public users addUsers(@RequestBody users users){
       return sessionRepository.save(users);
    }

}
