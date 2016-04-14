package doppler.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		return null;
	}

	@Override
	public void save(User user) {
		userDao.insert(user);
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public User delete(Integer id) {
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public List<String> getAllLoginNames(String loginName) {

		return userDao.getAllLoginNames(loginName);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String getLoginName(String arg) {
		return userDao.getLoginName(arg);
	}

	@Override
	public boolean validateUser(String loginName, String password, HttpSession session) {
		User user=userDao.getUserByLoginNameandPwd(loginName, password);
		if(user!=null){
			session.setAttribute("currentUser", user);
			return true;
		}
		return false;
	};
	
	@Override
	public void checkUniqueLoginName(String loginName_arg, HttpServletResponse response) {
		String loginName = this.userDao.getLoginName(loginName_arg);
		if (loginName != null) {
			renderData("1", response);
		} else {
			renderData("0", response);
		}
	}

	public void renderData(String result, HttpServletResponse response) {
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.print(result);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}

	}

}
