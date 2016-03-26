package doppler.service;

import java.util.List;

import doppler.domain.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserById(Integer id);
	void save(User user);
	User update(User user);
	User delete(Integer id);
}
