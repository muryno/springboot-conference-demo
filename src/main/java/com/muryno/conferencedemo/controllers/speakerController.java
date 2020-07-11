package com.muryno.conferencedemo.controllers;


import com.muryno.conferencedemo.models.speaker;
import com.muryno.conferencedemo.repositories.speakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/speaker")
public class speakerController {

    @Autowired
    private speakerRepository speakerRepository;


    @GetMapping
    @RequestMapping("{id}")
    public speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @GetMapping
    public List<speaker> getSpeaker(){
        return speakerRepository.findAll();
    }

    @PostMapping
    public speaker create(@RequestBody final speaker speaker){

        return  speakerRepository.saveAndFlush(speaker);

    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public speaker updateSpeaker(@PathVariable Long id , @RequestBody speaker speaker){
        speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
