package doppler.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import doppler.dao.BookDao;
import doppler.domain.Book;
import doppler.domain.User;
import doppler.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Resource
	private BookDao bookDao;

	public void saveBookWihtUser(User currentUser, int bookId) {
		if (currentUser != null && bookId != 0) {
			bookDao.saveBookWihtUser(bookId, currentUser.getId());
		}

	}

	public List<Book> getUserBooks(User currentUser) {
		List<Book> books = null;
		if (currentUser != null) {
			books = bookDao.getBooksByUserId(currentUser.getId());
			if (books.size() <= 0)
				return null;
		}

		return books;
	}

	
	public boolean userHasBook(User currentUser, int bookId){
		if(currentUser != null && bookId !=0){
			Integer result = bookDao.getBookIdWithUserIdandBookId(bookId, currentUser.getId());
			if(result != null)
				return true;
		}
		return false;
	}
	
	public List<Book> getAllBooks(){
		return bookDao.getAll();
	}
	
}
