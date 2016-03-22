package doppler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistController {
	static{
		System.out.println("RegistController loaded");
	}
	@RequestMapping("/register")
	public String registForm(){
		return "registPage";
	}
}
