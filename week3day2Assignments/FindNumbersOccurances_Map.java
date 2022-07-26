package week3.day2.assignments;

import java.util.Map;
import java.util.TreeMap;

public class FindNumbersOccurances_Map {

	public static void main(String[] args) {
		/*
		 * Psuedcode:
		 * 
		 * 1) Create Map -> TreeMap
		 * 2) For loop -> each number -> add to the map
		 * 3) If it is exist -> update it with + 1
		 * 	  Else -> new entry with 1 as value
		 INPUT---------------
		 * Input array numbers, each occurances
		 * input: {2,3,5,6,3,2,1,4,2,1,6,-1};
		 * output: 2 -> 3 , 3 -> 2, 4 -> 1 
		 * Order: Ascending Order
		 */

		int [] nums = {2,3,5,6,3,2,1,4,2,1,6,-1};
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int value : nums) {
				int key = value;
				if(map.containsKey(key)) {	
					int val = map.get(key);
					map.put(value, val+1);
				}else
				{
					map.put(value, 1);
				}
				}System.out.println(map.entrySet());
	}

}
