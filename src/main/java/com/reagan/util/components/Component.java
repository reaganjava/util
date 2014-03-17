package com.reagan.util.components;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;

import com.reagan.util.Arith;
import com.reagan.util.Base64Utils;
import com.reagan.util.CookieManager;
import com.reagan.util.KeyGenerater;
import com.reagan.util.MD5;
import com.reagan.util.SignProvider;
import com.reagan.util.Signaturer;
import com.reagan.util.TypeFormat;
import com.reagan.util.ValidatorUtil;
import com.reagan.util.XmlDom;

/**
 * <p>Description:统一组件类，将各个需要的组件加入到该类中统一使用</p>
 * @date 2013年8月23日
 * @author reagan
 * @version 1.0
 * <p>Company:Mopon</p>
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
	 * TABLE 时间区间查询方式
	 */
	public static final String TABLE_CREADATE ="create_date";
	
	/**
	 * TABLE 名字模糊查询
	 */
	public static final String TABLE_NAME = "tableName";

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

	
}
