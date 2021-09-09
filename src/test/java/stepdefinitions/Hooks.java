package stepdefinitions;

import cucumber.api.java.After;
import utils.DriverUtils;

public class Hooks {
	
	@After
	public void tearDown() {
		DriverUtils.closeDriver();
	}

}
