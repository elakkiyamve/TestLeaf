package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MissingElementInAnArray_List {

	public static void main(String[] args) {
	
				// Sort the array	
				// loop through the array (start i from arr[0] till the length of the array)
					// check if the iterator variable is not equal to the array values respectively

						// print the number and once printed break the iteration
						
						
		int[] arr = {1,2,3,10,4,7,6,8,9};
		Arrays.sort(arr);
		
		List <Integer> list = new ArrayList<Integer>();
		for (Integer integer : arr) {
			list.add(integer);
		}
		list.add(0, 0);
		
		for (int i = 0; i < list.size(); i++) {
			if(!list.contains(i))
			System.out.print("Missing number  : " +i);
			}
	   }
	}
