package doppler.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import doppler.domain.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(Integer id);

	void save(User user);

	User update(User user);

	User delete(Integer id);

	List<String> getAllLoginNames(String loginName);

	String getLoginName(String arg);

	public void checkUniqueLoginName(String loginName_arg, HttpServletResponse response);
}
