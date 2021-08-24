package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage {

	protected WebDriver driver;

	public StorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@href='/store']")
	private WebElement menuLojas;

	@FindBy(css = "#tabs-lojas-tab-cadastrar-loja")
	private WebElement menuCadastrarLojas;

	@FindBy(id = "formBasicEmail")
	private WebElement campoNovaLoja;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnCadastrar;

	@FindBy(id = "tabs-lojas-tab-lojas-cadastradas")
	private WebElement menuListaDeLojas;

	@FindBy(css = "tr:last-child td:nth-child(2)")
	private WebElement novaLoja;

	@FindBy(css = "tr:last-child td:nth-child(3) a:first-of-type")
	private WebElement btnEditar;

	@FindBy(css = "tr:last-child td:nth-child(3) div:nth-child(2) a:last-of-type")
	private WebElement btnRemover;

	public void esperarElemento(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}

	public void acessarMenuLojas() {
		esperarElemento(menuLojas);
		menuLojas.click();
	}

	public void acessarMenuCadastrarLojas() {
		esperarElemento(menuCadastrarLojas);
		menuCadastrarLojas.click();
	}

	public void preencherNovoNomeDeLoja(String newStoreName) {
		esperarElemento(campoNovaLoja);
		campoNovaLoja.clear();
		campoNovaLoja.sendKeys(newStoreName);
	}

	public void cadastrarNovaLoja() {
		esperarElemento(btnCadastrar);
		btnCadastrar.click();
	}

	public void validarAlert() {
		try {
			Thread.sleep(500);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals("Loja cadastrada com sucesso!", alertText);
			assertTrue(alertText.equals("Loja cadastrada com sucesso!"));
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void mostrarMenuComListaDeLojas() {
		esperarElemento(menuListaDeLojas);
		menuListaDeLojas.click();
	}

	public void validaNovaLoja(String arg1) {
		esperarElemento(novaLoja);
		assertEquals(arg1, novaLoja.getText());
	}

	public void btnEditarNomeDaLoja() {
		esperarElemento(btnEditar);
		btnEditar.click();
	}

	public void validarAlertDeEditarNome() {
		try {
			Thread.sleep(500);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals("editado com sucesso", alertText);
			assertTrue(alertText.equals("editado com sucesso"));
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void btnRemoverLoja() {
		esperarElemento(btnRemover);
		btnRemover.click();
	}

	public void confirmarRemocaoDaLoja() {
		try {
			Thread.sleep(500);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals("Tem certeza que deseja deletar?", alertText);
			assertTrue(alertText.equals("Tem certeza que deseja deletar?"));
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void confirmacaoDeLojaRemovida() {
		try {
			Thread.sleep(500);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals("deletado com sucesso", alertText);
			assertTrue(alertText.equals("deletado com sucesso"));
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validarRemocaoDoNomeDaloja() {
		assertNotEquals(novaLoja, "Americanas");
	}

}
