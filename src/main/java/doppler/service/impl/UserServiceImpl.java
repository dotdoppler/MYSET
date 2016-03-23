package doppler.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import doppler.domain.User;
import doppler.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		System.out.println("call save()");
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
