package doppler.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import doppler.service.UserService;

@Controller

public class LoginController {
	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = { "/", "/login" })
	public String home() {
		return "WEB-INF/html/loginPage.html";
	}

}
