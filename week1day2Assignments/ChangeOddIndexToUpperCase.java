package week1.day2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		
		String test = "changeme";
		char[] chars = test.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			//System.out.println(chars[i]);
			if(i % 2 != 0)
			{
				char upper = Character.toUpperCase(chars[i]);
				System.out.println(upper);
			}
			else
				System.out.println(chars[i]);
			}
		
	}
	
}
