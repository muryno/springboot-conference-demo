package com.muryno.conferencedemo.controllers;


import com.muryno.conferencedemo.models.session;
import com.muryno.conferencedemo.models.speaker;
import com.muryno.conferencedemo.repositories.sessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class sessionController {

    @Autowired
    private sessionRepository sessionRepository;


    @GetMapping("/{id}")
    public session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @GetMapping("/")
    public List<session> getSession(){
        return sessionRepository.findAll();
    }

    @PostMapping("/add")
    public session create(@RequestBody final session session){
        return  sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping("/delete/{id}")
   // @PreAuthorize("hasAuthority('session_id')")
    public void deleteId(@PathVariable Long id){
         sessionRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public session update(@PathVariable Long id,@RequestBody session session ){

        session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return  sessionRepository.saveAndFlush(existingSession);
    }
}
