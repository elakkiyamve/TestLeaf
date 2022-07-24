package week3.day1.Banking;

public class BankInfo {

	/*
	 * Assignment3
============
    Class     :BankInfo
    Methods :saving(),fixed(),deposit()

     Class     :AxisBank
     Methods :deposit()

Description:
You have to override the method deposit in AxisBank.
	 */
	
	public void saving() {
		System.out.println("method having savings");
	}
	public void fixed() {
		System.out.println("method having fixed deposit terms");
	}
	public void deposit() {
		System.out.println("fixed deposit : Bank info");
	}
	
	
	public static void main(String[] args) {
		AxisBank AB = new AxisBank();
		AB.saving();
		AB.fixed();
		AB.deposit();
		AB.deposit(20000);
	}
}
