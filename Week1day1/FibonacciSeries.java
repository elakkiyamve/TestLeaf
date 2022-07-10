package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		int num1=0, num2=1,sum=0, count=11;
		System.out.println(num1);
		System.out.println(num2);
		
		/* Print first number
Iterate from 1 to the 11
Add first and second number assign to sum
Assign second number to the first number
Assign sum to the second number
Print sum
*/
		
			for(int i=2;i<count; ++i)
		{
			sum = num1 + num2;
			System.out.println(sum);
			num1 =num2;
			num2= sum;
		}
	}

}
