package doppler.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import doppler.domain.Book;
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
			 if( !bookService.userHasBook(currentUser, bookId)){
				 bookService.saveBookWihtUser(currentUser, bookId); 
				 return "1";
			 }
			 else 
			return "0";
		}
		return "";
	}
	
	
	@RequestMapping(value = {"/currentUserBooks"} , method = { RequestMethod.GET})
	public @ResponseBody List<Book> getUserBooks(HttpSession session){
		if(session != null){
			 User currentUser = (User)session.getAttribute("currentUser");
			 List<Book> myBooks = bookService.getUserBooks(currentUser);
			 if(myBooks != null)
				 return myBooks;
		}
		return null;
	}
	
	@RequestMapping(value = {"/showBooks"} , method = { RequestMethod.GET})
	public @ResponseBody List<Book> showBooks(){
		List<Book> allBooks = bookService.getAllBooks();
		
		return allBooks;
	}
}
