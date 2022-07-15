package CodingReview;

public class Armstrong {

public static void main(String[] args) {
	boolean result = Armstrong.isArmStrong(125);
     System.out.println(result);             
		
}	

public static boolean isArmStrong(long num) {

	 int digits = String.valueOf(num).length();
     int sum = 0;
     long value = num;
     for(int i=1;i<=digits;i++) {
         long remainder = value%10;
         value = value/10;
         sum = sum + (int)Math.pow(remainder, digits);
     }
     if(sum==num)
    	 return true;
     else
	return false;		
}
}

