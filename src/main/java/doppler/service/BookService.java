package doppler.service;

import java.util.List;

import doppler.domain.Book;
import doppler.domain.User;

public interface BookService {
	
	 public void saveBookWihtUser(User currentUser,int bookId);
	 
	 public List<Book> getUserBooks(User currentUser);
	 
	 public boolean userHasBook(User currentUser,int bookId);
}
