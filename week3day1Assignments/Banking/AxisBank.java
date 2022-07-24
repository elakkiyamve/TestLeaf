package week3.day1.Banking;

public class AxisBank extends BankInfo {

	public void deposit(int balance) {		//overloading
			System.out.println("Deposit amount : Axis Bank " + balance);
			
	}
	
	public void deposit() {			//overiding
		System.out.println("fixed deposit : Axis Bank");
	}
	
}
