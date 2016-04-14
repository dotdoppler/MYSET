package doppler.service;

import doppler.domain.User;

public interface BookService {
	
	 public void saveBookWihtUser(User currentUser,int bookId);
}
