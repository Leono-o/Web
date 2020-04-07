package com.hotmail.ch.leon.familymedia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VideoController {


    @RequestMapping(value="/videos", method=RequestMethod.GET)
    public String mainPage() {
        return "hello restful";
    }

    @RequestMapping(value="/videos", method=RequestMethod.POST)
    public String listAllVideow() {
        return "hello restful";
    }
}