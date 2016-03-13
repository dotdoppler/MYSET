package doppler.myset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Controller_index {
@RequestMapping("/home")
 public String home(){
	 return "homepage";
 }
}
