package com.jisiben.hrms.controller;

import javax.annotation.Resource;

import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, ModelMap model) {
		return getUserService().login(username, password)
				.map((User user)->{model.put("error", ""); return "index";})
				.orElseGet(()->{model.put("error", "用户名或密码错误"); return "login";});
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