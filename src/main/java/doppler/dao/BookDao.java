
package doppler.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import doppler.domain.Book;

/**
 *@describe 
 *@version v1.0  2016年4月9日
 *@author dotdoppler@yeah.net
 */
public interface BookDao {
	
  public void saveBookWihtUser(@Param("bookId") int bookId ,@Param("userId") int userId);
  
  public List<Book> getBooksByUserId(@Param("userId") int userId);
  
  public Integer  getBookIdWithUserIdandBookId(@Param("bookId") int bookId ,@Param("userId") int userId);
}
