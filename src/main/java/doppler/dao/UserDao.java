package doppler.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import doppler.domain.User;
@Repository("userDao")
public interface UserDao {
	List<User> getAllUsers();
	
	User getUser(Integer id);

	void insert(User user);

	User update(User user);

	User delete(Long id);
	
}
