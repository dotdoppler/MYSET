import java.io.IOException;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import doppler.dao.UserDao;
import doppler.domain.User;

public class MyBatisTest2 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static { 
		try {
			reader=Resources.getResourceAsReader("MyBatis-Configuration.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args)throws IOException {
		SqlSession session=sqlSessionFactory.openSession();
		//使用xml文件
		try {
			
	
		User user=session.getMapper(UserDao.class).getUser(1);
		System.out.println("mapper with Interface :"+user.getName()+"   "+user.getLoginName());
			
		} finally {
		session.close();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	
}
