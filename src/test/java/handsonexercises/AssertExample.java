package handsonexercises;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExample {
	
	@Test
	public void testAssert() {
		//Filled and submitted the form
		// Verifying the data
		Assert.assertTrue(true);
		Assert.assertEquals("Anamika", "Anamika");
		Assert.assertEquals("Ekka", "Ekka");
		Assert.assertEquals("Tester", "Tester");
		Assert.assertTrue(true);
	}
	
	@Test
	public void softAssertTest() {
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(true);
		sf.assertEquals("Anamika", "Anamika");
		sf.assertEquals("Ekka", "qkka");
		sf.assertEquals("Tester", "tester");
		sf.assertTrue(false);
		sf.assertAll();
	}
}