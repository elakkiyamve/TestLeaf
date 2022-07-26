package week3.day2.assignments;


import java.util.HashMap;
import java.util.Map;


public class FirstMostDuplicate_Map {

	public static void main(String[] args) {
		/* input: abbaba
		 * output: b
		 * 
		------------------------------------
		 * Psuedocode
		 * 
		 * 1) Map -> HashMap 
		 * 2) String -> ch[] -> Get all the character -> occurance
		 * 3) Keep comparing the occurance with other values -> max value -> character
		 * 
		 */

		String input = "abbaba";
		char[] ca = input.toCharArray(); 	//string - character array
		int max=0; int value =0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();	// map - hashmap
		

		//find first most duplicate character
		for (int i = 0; i < input.length(); i++) {
			char key = ca[i];

			if(map.containsKey(key)) {
				value = map.get(key);
				map.put(ca[i], value+1);
				max = map.get(key);
				if (max > value) {
					System.out.println("First Most Duplicate : " +ca[i]);
					break;
					}
			}else
				map.put(ca[i], 1);
		}
	}
}


