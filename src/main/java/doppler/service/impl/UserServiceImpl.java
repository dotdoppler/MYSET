package doppler.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import doppler.dao.UserDao;
import doppler.domain.User;
import doppler.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
		
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
		 userDao.insert(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.getUser(id);
	}
	
	@Override
	public List<String> getAllLoginNames(String loginName) {
		// TODO Auto-generated method stub
		return userDao.getAllLoginNames(loginName);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public String getLoginName(String arg) {
		// TODO Auto-generated method stub
		return userDao.getLoginName(arg);
	}



	
	


}
