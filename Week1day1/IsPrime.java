package week1.day1;

public class IsPrime {
public static void main(String[] args) {
	/*Iterate through all numbers from 2 to n-1 (input) and 
for every number check if it divides n (input). 
If we find any number that divides, print prime.
If nothing divides, then print non-prime
*/
	int total=20;
	
	for(int n=2; n<=total;n++) {
		boolean check = true;
	
	for(int i=2;i<=n/2; i++) {
		if(n%i==0) {
			check = false;
			break;
		}
	}
		
	if(!check)
		System.out.println(n + " is non-prime");
	else
		System.out.println(n + " is prime");
	}
}
}