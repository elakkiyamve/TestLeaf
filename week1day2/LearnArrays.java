package week1.day2;

public class LearnArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int [] scores = {50,51,52,53,50,51,55,55,55,55,50,50,50,50};
int length = scores.length;
System.out.println(length);
int No = 50, count = 0;

for(int i=0; i<scores.length; i++) {
	if(scores[i]==No) {
		count++;
				}
		}
System.out.println(count);
}

}
