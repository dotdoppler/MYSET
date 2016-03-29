package doppler.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//使用静态工厂方法 单例模式
public class DateUtil {
	private static DateUtil dateUtil;
	private DateUtil(){}
	
	public static DateUtil getInstance(){
		if(dateUtil==null){
			return new DateUtil();
		}	
			return dateUtil;
	}
	//获取当前日期
	public String getCurrentDate(){
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	public Date getDate(){
		return new Date();
	}
	
	public String getCurrentTime(){
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}
	
}
