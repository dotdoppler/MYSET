package doppler.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import doppler.domain.User;
@Repository("userDao")
public interface UserDao {
	List<User> getAllUsers();
	
	User getUser(Integer id);

	void insert(User user);

	User update(User user);

	User delete(Long id);
	
	List<String> getAllLoginNames(String loginName);
	
	String getLoginName(String arg);
	//查询多个参数要注意，这里采用的是注解
	User getUserByLoginNameandPwd(@Param("loginName") String loginName,@Param("password")String password);
}
