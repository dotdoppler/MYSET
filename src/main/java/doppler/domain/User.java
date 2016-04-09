package doppler.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**用户的实体类
 * @author dotdoppler@yeah.net
 * @version v1.0
 */
public class User implements Serializable{

	private static final long serialVersionUID = -8403966225572226345L;
	private int id;
	private String loginName;
	private String name;
	private String password;
	private Date registTime;
	private List<Book> books;
	
	
	@Override
	public String toString() {
		return "User [loginName=" + loginName + "]";
	}
	
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
