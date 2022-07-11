package week1.day2;

import java.util.Arrays;

public class MinMaxDuplicateArray {
	public static void main(String[] args) {

		int min =0 ,max =0;
		int numbers[] = {0,9,5,8,7,4,5,0,6,9,8,7,4,5,6,9,8,7,4,5,6};

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
			else if (numbers[i] < min) {
				min = numbers[i];
			}

		}
		System.out.println("minimum value is " + min);
		System.out.println("maximum value is " +max);

		Arrays.sort(numbers);

		for(int i = 0; i <numbers.length-1; i++)
		{    
			if(numbers[i] == numbers[i+1])  
				System.out.println("duplicates  " + numbers[i]);       
		}   
	}
}
