public class Solution {	
	public static int getFactorial(int n) {	
		int result = 1;
		if (n < 2) {
			return result;
		}
		for (int i = 2; i <= n; i++) {
			result = result * i;
		}
		return result;
	}
}