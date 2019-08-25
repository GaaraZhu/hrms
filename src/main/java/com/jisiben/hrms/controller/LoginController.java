package com.jisiben.hrms.controller;

import javax.annotation.Resource;

import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Optional;

// TODO: substitute this with UserController
@Controller
public class LoginController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, ModelMap model) {
		Optional<String> error= Arrays.asList(username, password)
				.stream()
				.filter(StringUtils::isEmpty)
				.findAny()
				.map((String val) -> Optional.of("用户名或密码错误"))
				.orElse(
						getUserService().login(username, password)
								.map((User user)->Optional.<String>empty())
								.orElse(Optional.of("用户名或密码错误")));
		if (error.isPresent()) {
			model.put("error", error.get());
			return "login";
		} else {
			return "index";
		}
	}

	@RequestMapping("logout")
	public String logout(@RequestParam(value = "username", required = false) String username,
			RedirectAttributes redirectAttributes) {
		return "redirect:/login";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}