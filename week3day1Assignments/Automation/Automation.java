package week3.day1.Automation;

public class Automation extends MultipleLangauge implements TestTool, Language{
/*
 * 
 * Assignment 5 on Abstraction
===========
Interface :Language
     Methods   :Java()
     Interface :TestTool
     Methods   :Selenium()
     AbstractClass :MultipleLangauge
     Methods   :python() and un implemented method as ruby()
  Execution class: Automation 
Implement all the methods of interface and abstract class in Automation class
 */
	public void Java() {
		System.out.println("Language Interface - Java method");
	}

	public void Selenium() {
		System.out.println("Selenium Interface - Selenium method");
		}

	@Override
	public void python() {
		System.out.println("Python language");
		}

	@Override
	public void ruby() {
		System.out.println("Ruby language");
	}
	public void JavaAutomate() {
		System.out.println("Java Automation");
	}
	public static void main(String[] args) {
		Automation ac = new Automation();
		ac.Java();
		ac.Selenium();
		ac.python();
		ac.ruby();
		ac.JavaAutomate();
	}
}
