package doppler.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import doppler.domain.User;
import doppler.service.UserService;

@Controller
public class RegistController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/regist", method = { RequestMethod.GET })
	public String renderRegistForm() {

		return "WEB-INF/html/registPage.html";
	}

	@RequestMapping(value = "/regist", method = { RequestMethod.POST })
	public String invoke_registUser(@ModelAttribute User user) {

		userService.save(user);
		return "redirect:/login";
	}

	@RequestMapping(value = "/checkUniqueLoginName", method = { RequestMethod.GET })
	void invoke_checkUniqueLoginName(@RequestParam("loginName") String loginName_arg, HttpServletResponse response) {
		userService.checkUniqueLoginName(loginName_arg, response);
	}

}
