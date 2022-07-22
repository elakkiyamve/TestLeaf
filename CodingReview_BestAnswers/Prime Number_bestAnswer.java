public class Solution {	
	public static boolean isPrime(int n) {	
		boolean bNonPrime =true;
		if(n<0) {
			throw new IllegalArgumentException("Negative Number");
		}
		for( int i=2;i<=n/2;i++) {
			if(n%i==0) {
				bNonPrime = false;
				break;
			}
		}
			return bNonPrime;
	}
}