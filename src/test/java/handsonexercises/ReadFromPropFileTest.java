package handsonexercises;

import org.testng.annotations.Test;

import util.DataProvider;

public class ReadFromPropFileTest {
	
	@Test
	public void testReadFromPropFile() {
		String propFile = "src/test/resources/base.prop";
		String propName = "searchParam";
		
		String value = DataProvider.getTestData(propFile, propName);
		System.out.println(value);
		System.out.println(DataProvider.getTestData(propFile, "timeout"));
	}
}