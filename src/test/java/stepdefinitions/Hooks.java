package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import utils.DriverUtils;

public class Hooks {

	@After
	public void embedScreenshotOnFail(Scenario s) throws IOException {
		if (s.isFailed())
			try {
				final byte[] scrFile = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);
				s.embed(scrFile, "image/png");
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
		DriverUtils.closeDriver();
	}

}
