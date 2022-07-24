package week3.day1.org.student;

import week3.day1.org.college.College;
import week3.day1.org.department.Department;

public class Student {
	/*
	 * 
	 * Assignment2
=============
     Package   :org.student
     Class        :Student
     Methods   :studentName(),studentDept(),studentId()
  
Description:
create above 3 class and call all your class methods into the Student using multilevel inheritance.
	 */
	
	public void studentName() {
	System.out.println("student name : Akash");
	}
	public void studentDept() {
		System.out.println("student dept : CSE");
	}
	public void studentId() {
		System.out.println(" Student id is 11221");
	}
	
	public static void main(String[] args) {
		College c = new College();		
		c.collegeCode(); 	
		c.collegeName();
		c.collegeRank();
		c.studentDept();
		c.studentId();
		c.studentName();
	Department dept = new Department();
		dept.studentName();
		dept.deptName();
}
}
