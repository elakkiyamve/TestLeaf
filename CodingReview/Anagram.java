package CodingReview;

import java.util.Arrays;

public class Anagram {

public static boolean isAnagram(String input1, String input2) {
		
		char[] ch1 = input1.toCharArray();
		char[] ch2 = input2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		for(int i=0;i<=ch2.length-1;i++) {
			if(ch1[i]!=ch2[i])
			return false;
			}
		return true;
}
	public static void main(String[] args) {
		boolean result = Anagram.isAnagram("hello","post");
		System.out.println(result);
	}
}
