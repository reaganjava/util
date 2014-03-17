package com.reagan.util;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LocalCached {
	
	private static Map<String, Object> values = new ConcurrentHashMap<String, Object>();
	
	public static void add(String key, Object value) {
		values.put(key, value);
	}
	
	public static Object get(String key) {
		return values.get(key);
	}
	
	public static void remove(String key) {
		values.remove(key);
	}
	
	public static Set<String> getKeys() {
		return values.keySet();
	}

	public static void clear() {
		values.clear();
	}
	
}
