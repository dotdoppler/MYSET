package doppler.dao;

import java.util.List;

import doppler.domain.User;

public interface UserDao {
	List<User> getAllUsers();
	User getUser(Long id);
	User save(User user);
	User update(User user);
	User delete(Long id);
}
