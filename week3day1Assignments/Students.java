package week3.day1;

public class Students {

	/*
	 * Assignment 4
==============

      Class: Students
      Methods: getStudentInfo()

Description: 
Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber
	 */
	
	public void getStudentInfo(int id) {
		System.out.println("single argument " + id);
	}
	public void getStudentInfo(int id, String name) {
		System.out.println("two argument " + id + "- "+ name);
	}
	public void getStudentInfo(String email, long phoneNumber) {
		System.out.println("two argument " + email +"- "+ phoneNumber);
	}
	public void getStudentInfo(int id, String name, String email) {
		System.out.println("three arg  " +id +" - "+ name+"- " + email);
	}
	public void getStudentInfo(int id,  long phoneNumber,String email, String name) {
		System.out.println("four args " + id +"- "+ phoneNumber+"- "+ name+"- " + email  );
	}
	
	public static void main(String[] args) {
		Students stud = new Students();
		stud.getStudentInfo(123);
		stud.getStudentInfo(123, "Jai");
		stud.getStudentInfo("jai@info.com", 9999999999l);
		stud.getStudentInfo(123,"Jai", "jai@info.com");
		stud.getStudentInfo(123, 9999999999l, "Jai@info.com", "Jai");
	}
}
