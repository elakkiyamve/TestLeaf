package week1.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String test = "I am a software tester";
		String change[] = test.split(" ");
		
		String reverse[] = test.split(" ");
		
		int length = change.length;
		for (int i = 0; i < length; i++) {
				if(i % 2 == 0) {
				System.out.print(change[i] + " ");
				
				}
				if(i % 2 != 0)
				{
					String result = reverse[i];
					
					char[] value = result.toCharArray();
				for(int j=value.length-1; j>=0; j--) {
					String job = String.valueOf(value[j]);
				System.out.print(job + "");
				}
				}	
			}
			}
		
		}
	






