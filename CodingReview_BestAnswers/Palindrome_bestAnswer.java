import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
public class Solution {   
   	 public static boolean checkPalindrome(String str) {
		String revStr = "";
		int strLength = str.length();

		for (int i = strLength - 1; i >= 0; --i) {
			revStr = revStr + str.charAt(i);
		}
		if (str.toLowerCase().equals(revStr.toLowerCase()))
			return true;
		else
			return false;
	}
}