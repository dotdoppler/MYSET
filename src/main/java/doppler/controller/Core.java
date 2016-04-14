package doppler.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import doppler.domain.User;
import doppler.service.BookService;

@Controller
public class Core {
	@Resource(name = "bookService")
	private BookService bookService;
	
	
	@RequestMapping(value = {"/getBook"} ,method = { RequestMethod.GET })
	public @ResponseBody String getBook(@RequestParam("id") int  bookId,HttpSession session){
		
		if(session != null){
			 User currentUser = (User)session.getAttribute("currentUser");
			 bookService.saveBookWihtUser(currentUser, bookId);
		}
		return "call back";
	}
}
