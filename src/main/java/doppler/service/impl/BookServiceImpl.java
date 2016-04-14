package doppler.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import doppler.dao.BookDao;
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

	

}
