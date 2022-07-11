package week1.day2;

//import java.util.Arrays;

public class CountStringChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "cognizant";
		char ch = 'n';
		int count =0;
		char[] ch1 = str.toCharArray(); 
		// Arrays.sort(ch1);
		
		System.out.println(str);
		for (int i = 0; i < ch1.length-1; i++) {
			if(ch == ch1[i]) {
				count++;
		}
	} 
		System.out.println(ch + " character count is " + count);
	}
}
