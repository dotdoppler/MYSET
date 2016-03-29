package doppler.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import doppler.domain.User;
import doppler.service.UserService;
import doppler.util.DateUtil;

@Controller
public class RegistController {
	@Resource
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
		user.setRegistTime(DateUtil.getInstance().getDate());
		userService.save(user);
		return "loginPage";
	}
	@RequestMapping(value="/checkUniqueLoginName",method={RequestMethod.GET})
	void checkUniqueLoginName(@RequestParam("loginName") String loginName){
		System.out.println("hhh");
		System.out.println(loginName);
		
	String string=userService.getLoginName(loginName);

	if (string=="") {
		System.out.println(string.length());
	}
	else{
		System.out.println(string);
	}
	}
	

}
