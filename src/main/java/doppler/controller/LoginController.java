package doppler.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import doppler.service.UserService;
import doppler.util.DateUtil;

@Controller

public class LoginController {
	static{
		System.out.println("LoginController loaded");
	}
	@Resource(name="userService")
	private UserService userService;
@RequestMapping(value={"/","/loginPage"})
 public String home(Model model){
	
	model.addAttribute("today", DateUtil.getInstance().getCurrentDate());
	model.addAttribute("time", DateUtil.getInstance().getCurrentTime());
	 return "loginPage";
 }

}
