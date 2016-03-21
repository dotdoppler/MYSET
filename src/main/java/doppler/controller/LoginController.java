package doppler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import doppler.util.DateUtil;

@Controller

public class LoginController {
	static{
		System.out.println("LoginController loaded");
	}
@RequestMapping(value={"/","/loginPage"})
 public String home(Model model){
	
	model.addAttribute("today", DateUtil.getInstance().getCurrentDate());
	model.addAttribute("time", DateUtil.getInstance().getCurrentTime());
	 return "loginPage";
 }

}
