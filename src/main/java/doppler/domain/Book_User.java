package doppler.domain;

import java.util.Date;

/**
 *@describe  描述Book与User之间的映射关系
 *@version v1.0  2016年4月9日
 *@author doppler@yeah.net
 */
public class Book_User {
	private User user;
	private Book book;
	private Date recordDate;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
}
