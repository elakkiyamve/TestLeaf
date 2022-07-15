package CodingReview;

public class Prime {
	 public static boolean isPrime(int n) {
	        for(int i=2; i<n; i++) {
	            if(n%i==0)
	            return false;
	        }
	        return true;
	    }
	    public static int nextPrime(int n) {
	        for(int i=n+1; true; i++) {
	            if(isPrime(i)==true)
	            	return i;
	        }
	    }
	    public static void main(String[] args) {
	        boolean v = Prime.isPrime(23);
			System.out.println(v);
	        System.out.println(Prime.nextPrime(23));
	    }
	}

