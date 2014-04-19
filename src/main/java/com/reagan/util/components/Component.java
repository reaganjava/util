package com.reagan.util.components;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;







import org.springframework.beans.factory.annotation.Autowired;

import com.reagan.util.CookieManager;
import com.reagan.util.XmlDom;

/**
 * <p>Description:统一组件类，将各个需要的组件加入到该类中统一使用</p>
 * @date 2013年8月23日
 * @author reagan
 * @version 1.0
 * <p>Company:reagan</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class Component {

	/**
	 * HTTP Client 采用RESTFUL方式发送请求
	 */
	public static final boolean RESTFUL = true;

	/**
	 * HTTP Client 采用传统键值对发送请求
	 */
	public static final boolean KEY_VALUE = false;
	
	/**
	 * HTTP Client 使用GET方式
	 */
	public static final boolean GET = true;

	/**
	 * HTTP Client 使用POST方式
	 */
	public static final boolean POST = false;
	
	/**
	 * SESSION 管理员ID键
	 */
	public static final String SESSION_ADMIN_ID = "ADMIN_ID";
	
	/**
	 * SESSION 管理员信息键
	 */
	public static final String SESSION_ADMIN_NAME = "ADMIN_NAME";
	
	
	public static final String SESSION_ADMIN_MENU_ITEM_LIST = "ADMIN_MENU_ITEM_LIST";
	
	public static final String SESSION_ADMIN_COMPANY_ID = "ADMIN_COMPANY_ID";
	
	/**
	 * TABLE 时间区间查询方式
	 */
	public static final String TABLE_CREADATE ="create_date";
	
	/**
	 * TABLE 名字模糊查询
	 */
	public static final String TABLE_NAME = "tableName";
	
	
	public  static final String JSONDATA = "jsonData";

	/**
	 * XML生成对象
	 */
	@Autowired
	protected XmlDom xmlDom;
	
	
	/**
	 * SESSION
	 */
	@Autowired
	protected CookieManager cookieManager;

	
	

	
	/** 
	 * 方法用途: 返回字符串键值
	 * 实现步骤: 由UUID生成的字符串主键<br>
	 * @return String 字符串唯一键值
	 */
	public synchronized String getUUIDPrimarykey() {
		return UUID.randomUUID().toString();
	}
	
	public String urlDecoder(String value) {
		try {
			value = URLDecoder.decode(value, "UTF-8");
			return new String(value.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
