package week1.day2;

import java.util.Arrays;

public class IsAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bAnagram = true;
		String str1 ="hello";
		String str2 ="eolhl";
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		if(ch1 == ch2) {
			System.out.println("matches");
		}
			else {
				System.out.println("not matched");
			}
		for(int i=0;i<=ch2.length-1;i++) {
			if(ch1[i]!=ch2[i]) {
				System.out.println("not anagram");
				bAnagram = false;
				
			}
		}
		if(bAnagram == true)
			System.out.println("Anagram");
	}

}
