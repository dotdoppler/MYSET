package doppler.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 	书的实体类
 * @author dotdoppler@yeah.net
 * @version v1.0
 */
public class Book implements Serializable{

	private static final long serialVersionUID = -4749716103836692016L;
	private int id;
	private String name;
	private String author;
	private String press;
	private Date dateOfPublication;
	private String type;
	private String cover;
	
	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	
}
