package com.hotmail.ch.leon.familymedia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FamilyMediaController {

	@RequestMapping("/login")
	public String welcome() {
		
		return "welcome";
	}
}