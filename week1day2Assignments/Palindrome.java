package week1.day2;

import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		
		boolean palindrome = true;
		String value = "madam";
		String rev_value = "admam";
		String check = "Madam";
		char[] ch1 = value.toCharArray();
		char[] ch2 = rev_value.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);

		for(int i=0;i<=ch2.length-1;i++) {
			if(ch1[i]!=ch2[i]) {
				System.out.println( rev_value + " is not palindrome");
				palindrome = false;
				
			}
		}

		if(palindrome == true)
			System.out.println( value + " is palindrome");
		
		if(value.equalsIgnoreCase(check))
			System.out.println( value + " is palindrome");
		else
			System.out.println( rev_value + " is not palindrome");	
		
	
		
		if(value.equals(rev_value))
			System.out.println( value + " is palindrome");
		else
			System.out.println( rev_value + " is not palindrome");
		
		if(value.equals(check))
			System.out.println( value + " is palindrome");
		else
			System.out.println( rev_value + " is not palindrome");
		
		
	}

}
