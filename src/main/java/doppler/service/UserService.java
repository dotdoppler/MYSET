package doppler.service;

import java.util.List;

import doppler.domain.User;

public interface UserService {
	List<User> getAllUsers();
	User getUser(Long id);
	User save(User user);
	User update(User user);
	User delete(Long id);
}
