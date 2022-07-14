

package PlayGround;

public class Palindrome {

	public static void main(String[] args) {
		
	
	String value = "madam";
	String revValue = "";
	
	//char[] ch1 = value.toCharArray();
	int length = value.length();
	
	for (int i = length-1; i>=0; i--) 
	revValue = revValue + value.charAt(i);
	System.out.println(revValue);
		
	if(value.equals(revValue))
		
		System.out.println("is palindrome");
	else
		System.out.println("is not palindrome");

	}
	
}