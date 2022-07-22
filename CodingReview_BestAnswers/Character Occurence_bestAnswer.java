import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
public class Solution {   
	public static int charCount(String str) {
		int count = 0;
		char[] ch = str.toCharArray();
		for (char each : ch) {
			if (each == 'e') {
				count++;
			}
		}
		return count;
	}
}