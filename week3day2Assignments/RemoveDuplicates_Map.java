package week3.day2.assignments;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicates_Map {

	public static void main(String[] args) {
		/*
		 * Pseudo code 
		 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 
		 * g) Displaying the String without duplicate words	
		 */
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		String text = "We learn java basics as part of java sessions in java week1";
		String[] str = text.split(" ");
		for (String key : str) {
				if(map.containsKey(key)) {
				Integer value = map.get(key);
				if(map.get(key)>1)
				map.put("",value );
			}else {
				map.put(key,1);
				
			}
		}
		String string = map.toString();
		System.out.println(string);
	}
}