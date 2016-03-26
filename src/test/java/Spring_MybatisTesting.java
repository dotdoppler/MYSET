

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import doppler.domain.User;
import doppler.service.UserService;
@ContextConfiguration("applicationContext.xml")
public class Spring_MybatisTesting {

	@Resource
	private UserService userService;
	
 
	
	@Test
	public void testGetUser(){
		userService.save(new User());
	}
	

}
