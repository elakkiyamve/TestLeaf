package CodingReview;

public class Factorial {	
	public static int getFactorial(int num) {
	int sum =1;
      for(int i=1; i<=num; i++){
              sum=sum*i;
            }
      return sum;
    }
  public static void main(String[] args){
   int result = Factorial.getFactorial(5);
      System.out.println(result);             
		
	}
}
