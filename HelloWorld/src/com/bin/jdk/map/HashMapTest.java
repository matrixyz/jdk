package com.bin.jdk.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
class Some{}
public class HashMapTest {
public static void main(String[] args) {
	 
	
	
}

void foreach(){
	Map<String,Some> m=new Hashtable<String,Some>();
	 
	m.put("abc",new Some());
	for(String key:m.keySet()){
		System.out.println(key);
	}
	for(Some val:m.values()){
		System.out.println(val);
	}
}
void foreach(Object o){
	 
	Map<String,Some> n=new HashMap<String,Some>();
	n.put("abc",new Some());
	Iterator<Map.Entry<String, Some>> entries = n.entrySet().iterator();  
	  
	while (entries.hasNext()) {  
		 Map.Entry<String, Some> entry = entries.next();  
		  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		
	}


}
}
