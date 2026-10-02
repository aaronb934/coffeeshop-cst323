package com.gcu.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller handles the main web pages
 */
@Controller
public class WebController {

	/**
	 * Shows the home page of the application
	 * 
	 * @param model holds data for the view
	 * @return the home html page
	 */
	@GetMapping("/")
	public String showMainApplicationPage(Model model) {
		model.addAttribute("title", "Home");
		return "home";
	}
}