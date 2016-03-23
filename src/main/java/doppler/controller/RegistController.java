package doppler.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doppler.domain.User;
import doppler.service.UserService;

@Controller
public class RegistController {
	@Resource(name="userService")
	private UserService userService;
	static{
		System.out.println("RegistController loaded");
	}
	@RequestMapping(value="/register",method={RequestMethod.GET})
	public String registForm(){
		return "registPage";
	}
	@RequestMapping(value="/register",method={RequestMethod.POST})
	public String registUser(User user){
		userService.save(user);
		return "loginPage";
	}
	
}
