package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsUtils {

	public static WebDriver driver;

	public static void esperarElemento(WebElement elemento) {
		driver = DriverUtils.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}

	public static void selecionar(WebElement elemento, String texto) {
		driver = DriverUtils.getDriver();
		Select dropDown = new Select(elemento);
		dropDown.selectByVisibleText(texto);

	}

}
