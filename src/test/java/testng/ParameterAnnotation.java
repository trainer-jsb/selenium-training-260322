package testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
	
	@Parameters({"browser"})
	@Test
	public void test(@Optional("internet Explorer") String  browser) {
		System.out.println("The output is " +browser);
	}
	
	@Parameters({"username","password"})
	@Test
	public void login(@Optional("testing") String username, @Optional("password")  String password) {
		System.out.println("Username is " +username);
		System.out.println("Password is " +password);
	}

}
