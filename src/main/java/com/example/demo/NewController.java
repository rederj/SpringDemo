package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {
	@RequestMapping("/new")
	public String index() {
		return "new";
	}
}