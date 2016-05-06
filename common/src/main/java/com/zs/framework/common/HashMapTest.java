package com.zs.framework.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest {
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(null, "aa");
		map.put("aa", null);
		//map.put(null, null);
		
		for(Entry<String, Object> entry : map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
