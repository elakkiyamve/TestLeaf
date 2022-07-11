package week1.day2;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "hello";
		
		char[] reverse = str1.toCharArray();
		System.out.println(reverse);
		/* for (int i = 0; i < reverse.length; i++) {
			System.out.println(reverse[i]);
			}
		*/
		int length = reverse.length;
		for (int i = length-1; i > 0 ; i--) {
				System.out.print(reverse[i]);
			}	
		
	}

}
