package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSecondLargest_List {

	public static void main(String[] args) {
		
				/*
				 Pseudo Code:
				 1) Arrange the array in ascending order
				 2) Pick the 2nd element from the last and print it
				 */
		
		int[] data = {3,2,11,4,6,7};
			Arrays.sort(data);
			
		List<Integer> list = new ArrayList<Integer>();
		for (Integer integer : data) {
			list.add(integer);
		}
		int size =list.size()-2;
		System.out.println("Second Largest No : " + list.get(size));
	}

}
