package CodingReview;

public class ReverseString {

	public static String reverseString(String input) {
		
		char[] value =  input.toCharArray();
		int length = value.length;
		String result ="";
		for (int i = length-1; i >= 0 ; i--) {
			result += value[i];
			}
		return result;
	}
	public static void main(String[] args) {
		String val = ReverseString.reverseString("TestLeaf");
		System.out.println(val);
	}
}
