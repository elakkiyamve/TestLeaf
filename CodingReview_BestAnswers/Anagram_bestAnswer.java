public class Solution {
	public static boolean isAnagram(String input1, String input2) {
		boolean status = true;
		if (input1.length() != input2.length()) {
			status = false;
		} else {
			char[] ArrayS1 = input1.toLowerCase().toCharArray();
			char[] ArrayS2 = input2.toLowerCase().toCharArray();
			Arrays.sort(ArrayS1);
			Arrays.sort(ArrayS2);
			status = Arrays.equals(ArrayS1, ArrayS2);
		}
		return status;	
	}
}