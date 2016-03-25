package doppler.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import doppler.domain.User;

public interface UserDao {
	List<User> getAllUsers();
	
	@Select("select * from User where id = #{id}")
	User getUser(Integer id);
	@Insert("")
	User save(User user);
	@Update("")
	User update(User user);
	@Delete("")
	User delete(Long id);
}
