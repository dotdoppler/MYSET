
package doppler.dao;

import org.apache.ibatis.annotations.Param;

/**
 *@describe 
 *@version v1.0  2016年4月9日
 *@author dotdoppler@yeah.net
 */
public interface BookDao {
	
  public void saveBookWihtUser(@Param("bookId") int bookId ,@Param("userId") int userId);
  
}
