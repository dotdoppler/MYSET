package doppler.myset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import doppler.myset.util.DateUtil;

@Controller

public class Controller_index {
	
@RequestMapping(value={"/","/home"})
 public String home(Model model){
	
	model.addAttribute("today", DateUtil.getInstance().getCurrentDate());
	model.addAttribute("time", DateUtil.getInstance().getCurrentTime());
	 return "homePage";
 }
@RequestMapping("/contactme")
public String contactPage(Model model){
	model.addAttribute("today", DateUtil.getInstance().getCurrentDate());
	model.addAttribute("time", DateUtil.getInstance().getCurrentTime());
	return "contactPage";
}

}
