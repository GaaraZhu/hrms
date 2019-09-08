package com.jisiben.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Logger;

@Controller
public class LoginController {
	protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(@RequestParam(value = "username", required = false) String username,
			RedirectAttributes redirectAttributes) {
		return "redirect:/login";
	}

}