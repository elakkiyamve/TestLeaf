package week3.day2.assignments;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FindIntersection_Set {

	public static void main(String[] args) {
		/*
		 * Pseudo Code
		
		 * a) Declare An array for {3,2,11,4,6,7};	 
		 * b) Declare another array for {1,2,8,4,9,7};
		 * c) Declare for loop iterator from 0 to array length
		 * d) Declare a nested for another array from 0 to array length
		 * e) Compare Both the arrays using a condition statement
		 
		 *  f) Print the first array (shoud match item in both arrays)
		 */
		
		Integer[] a = {3,2,11,4,6,7};
		Integer[] b = {1,2,8,4,9,7};
		Set<Integer> unique = new HashSet<Integer>();
		for (int j = 0; j < b.length; j++) {
			unique.add(a[j]);
			unique.retainAll(Arrays.asList(b));
	} System.out.println(unique);
	}
}
