package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class ClassicalController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/classical")
	public String index(Model model) {
		User user = userService.getUser(1);
		user.setDescription(user.getDescription()+"😄");
		userService.updateByPrimaryKey(user);
		model.addAttribute("User", user);
		return "classical";
	}
}