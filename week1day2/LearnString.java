package week1.day2;

public class LearnString {

	public static void main(String[] args) {
		
		//String literal
		String companyName = "TestLeaf";
		
		//String object
		String company = new String("TestLeaf");
		
		/**
		 * length() - to find how many characters  -- int
		 * toCharArray() - convert string to Character Array --char[]
		 * equals("") - to compare String content -- boolean(equalIgnoreCase)
		 * contains("") - compare the String with matching content -- boolean
		 * indexOf('') - will return the index position of given char -- 	int
		 * charAt(i) - character available in the given position -- 	character
		 * 
		 */
	
	int length = companyName.length();
	System.out.println(length);
	
	char[] chars = companyName.toCharArray();
	System.out.println(chars);
	for (int i = 0; i < chars.length; i++) {
		System.out.println(chars[i]);
		}
	
	boolean equals = companyName.equals(company);
	System.out.println(equals);
	
	char c = companyName.charAt(2);
	System.out.println(c);
	
	int indexOf = companyName.indexOf('t');
	System.out.println(indexOf);
	
	}
	
}
