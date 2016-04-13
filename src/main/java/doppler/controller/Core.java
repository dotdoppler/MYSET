package doppler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Core {
	@RequestMapping(value = {"/getBook"} ,method = { RequestMethod.GET })
	public @ResponseBody String getBook(@RequestParam("id") String  bookId){
		System.out.println(bookId);
		return "call back";
	}
}
