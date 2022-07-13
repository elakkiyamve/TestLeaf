package week1.day2;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		int count = 0;
		String change[] = text.split(" ");

		String text2[] = new String[text.length()];

		for (int i = 0; i < change.length; i++) {
			for (int j = i+1; j < change.length; j++) {
				if(change[i].equalsIgnoreCase(change[j]))
					count++;
				else 
					continue;
				if(count>1)
				change[i]= "";
			}
				text2[i] = change[i];
				System.out.print(text2[i] + " ");
			}

		}

	}
