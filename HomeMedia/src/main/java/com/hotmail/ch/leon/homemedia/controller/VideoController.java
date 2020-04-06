package com.hotmail.ch.leon.homemedia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class VideoController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/video")
    public String mainPage() {
        return "hello restful";
    }

    @RequestMapping("/video/all")
    public String listAllVideow() {
        return "hello restful";
    }
}