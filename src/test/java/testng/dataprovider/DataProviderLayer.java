package testng.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderLayer {
	
	@DataProvider(name = "data-provider-1")
	public static Object[][] firstDataProvider(){
		return new Object[][] {
			{"Tejashwini"}, {"Nishath"},{"Mubasheera"},{"Sharad"},{"Priyanka"}};
	}
}
