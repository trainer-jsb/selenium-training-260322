package testng;

import org.testng.annotations.Test;


public class TestClassFour {
	
	@Test(priority = 1, groups = {"Regression"} )
	public void testOne() {
		System.out.println("Test One");
	}
	
	@Test (priority = 2, groups = {"Regression","Sanity"}, timeOut = 3000)
	public void testTwo() {
		System.out.println("Test Two");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (priority = 3, groups = {"Regression"})
	public void testThree() {
		System.out.println("Test Three");
	}
	
	@Test (priority = 4, groups = {"Sanity"})
	public void testFour() {
		System.out.println("Test Four");
	}
	
}
