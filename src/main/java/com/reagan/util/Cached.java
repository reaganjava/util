package com.reagan.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * Description:本地缓存
 * </p>
 * 
 * @date 2014年5月26日 上午9:42:55
 * @author reagan
 * @version 1.0
 *          <p>
 *          Company:reagan
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2014
 *          </p>
 */
public class Cached {

	/**
	 * 存储用MAP
	 */
	private static Map<String, LinkedHashMap<Object, Object>> map = new HashMap<String, LinkedHashMap<Object, Object>>();

	private static ThreadLocal<Cached> local = new ThreadLocal<Cached>();;

	private Cached() {

	}

	public static Cached CachedFactory() {
		synchronized (local) {
			if (local.get() == null) {
				Cached cached = new Cached();
				local.set(cached);
			}
		}
		return local.get();
	}

	/**
	 * 方法用途: 添加数据<br>
	 * 实现步骤: <br>
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @throws
	 */
	public void add(String key, LinkedHashMap<Object, Object> objMap) {
		map.put(key, objMap);
	}

	/**
	 * 方法用途: 获取缓存中的值<br>
	 * 实现步骤: <br>
	 * 
	 * @param key
	 *            键
	 * @return object 存储的对象
	 * @throws
	 */
	public LinkedHashMap<Object, Object> get(String key) {
		return map.get(key);
	}

	/**
	 * 方法用途: 删除缓存中的值<br>
	 * 实现步骤: <br>
	 * 
	 * @param key
	 *            要删除值的键
	 * @throws
	 */
	public void remove(String key1, String key2) {
		map.get(key1).remove(key2);
	}

	/**
	 * 方法用途: 清除缓存中的数据<br>
	 * 实现步骤: <br>
	 * 
	 * @throws
	 */
	public void clear() {
		map.clear();
	}

	public ArrayList<Object> getArray(String key) {
		ArrayList<Object> objArray = null;
		if (null != map.get(key)) {
			objArray = new ArrayList<Object>();
			Iterator<Object> iter = map.get(key).keySet().iterator();
			while (iter.hasNext()) {
				objArray.add(map.get(key).get(iter.next()));
			}
		}
		return objArray;
	}

}
