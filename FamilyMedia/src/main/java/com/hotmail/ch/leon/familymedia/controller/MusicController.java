package com.hotmail.ch.leon.familymedia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotmail.ch.leon.familymedia.facade.MusicFacade;


@RestController
public class MusicController {


    @RequestMapping(value="/music", method=RequestMethod.GET)
    public String listAll() {
    	//MusicFacade ms = new MusicFacade();
    	//ms.getList();
    	return "ss";
    }

    @RequestMapping(value="/music", method=RequestMethod.POST)
    public String addMusic() {
        return "hello restful";
    }
}