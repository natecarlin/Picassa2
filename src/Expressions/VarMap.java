package Expressions;

import java.util.Map;

public class VarMap {
	public static Map<String, Expression> myMap;
	
	public static void setmap(String name, Expression expression){
			myMap.put(name, expression);
		}
	
	public static void clearmap(){
		myMap.clear();
	}
	
	public static Expression getexp(String name){
		if(myMap.containsKey(name)){
			return myMap.get(name);
		}
		else return null;
	}
	
	
}
