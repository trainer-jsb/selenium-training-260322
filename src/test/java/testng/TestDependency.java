package testng;

import org.testng.annotations.Test;

public class TestDependency {
	
	@Test (priority = 1)
	public void createEntity() {
		System.out.println("Create Test");
	}
	
	@Test (priority = 2, dependsOnMethods = "createEntity")
	public void updateEntity() {
		System.out.println("Update test");
	}
	
	@Test (priority = 3, dependsOnMethods = "createEntity")
	public void deleteTest() {
		System.out.println("Delete test");
	}

}
