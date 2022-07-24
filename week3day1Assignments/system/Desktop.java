package week3.day1.org.system;
/*
 * 
 * 
 * Assignment1
===========
     Package   :org.system
     Class        :Computer
     Methods   :computerModel()

     Class        :Desktop
     Methods   :desktopSize()

Description:
create above 2 class and call all your class methods into the Desktop using single inheritance.
 */


public class Desktop {
public void desktopSize() {
	System.out.println("Screen size is 20 inches");
}
public static void main(String[] args) {

	Computer c = new Computer();
	c.computerModel();
	c.desktopSize();
	}
}

