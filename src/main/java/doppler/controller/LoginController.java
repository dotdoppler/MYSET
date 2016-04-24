package doppler.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import doppler.domain.User;
import doppler.service.UserService;
import doppler.util.GlobalConstants;

@Controller

public class LoginController {
	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = {"/"})
	public String render_loginPage() {
		return "WEB-INF/html/loginPage.html";
	}
	@RequestMapping(value={"/home"})
	public String render_homePage(){
		return "WEB-INF/html/homePage.html";
	}
	
	@RequestMapping(value={"/login"} ,method = { RequestMethod.POST })
	public String invoke_validateUser(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password,HttpSession session){
		User user= userService.validateUser(loginName, password);
		if (user != null) {
			user.setPassword("");
			session.setAttribute(GlobalConstants.CURRENTUSER, user);
			return "redirect:/home";
		}
		
		return "redirect:/";
		
		
	}
	@RequestMapping(value={"/getCurrentUser"},method={RequestMethod.GET})
	public @ResponseBody User getCurrentUser(HttpSession session){
		User user=(User)session.getAttribute(GlobalConstants.CURRENTUSER);
		if (user!=null) 
			return user;
		
		return null;
	}
	

}
