package com.zs.framework.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	
	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		
		set.add(null);
		set.add("aa");
		set.add("aa");
		set.add(null);
		
		Iterator<Object> it = set.iterator();
		while(it.hasNext()){
			System.out.println("Set Value :"+it.next());
		}
	}

}
