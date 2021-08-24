package pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "user")
	private WebElement usuario;

	@FindBy(id = "password")
	private WebElement senha;

	@FindBy(tagName = "button")
	private WebElement btnLogin;

	@FindBy(className = "nav-brand-subtitle")
	private WebElement navGerenciador;
	
	@FindBy(xpath = "//div[@role='alert']" )
	private WebElement erroLoginMenssage;
	

	public void esperarElemento(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}

	public void preencherUsuario(String nomeUsuario) {
		esperarElemento(usuario);
		usuario.sendKeys(nomeUsuario);
	}

	public void preencherSenha(String senhaUsuario) {
		esperarElemento(senha);
		senha.sendKeys(senhaUsuario);
	}

	public void clicaBotaoLogin() {
		esperarElemento(btnLogin);
		btnLogin.click();
	}
	
	public void validarGerenciadorDeProdutos() {
		esperarElemento(navGerenciador);
		assertTrue(navGerenciador.isEnabled());
	}
	
	public void validarMensagemDeErroDeLogin() {
		esperarElemento(erroLoginMenssage);
		assertTrue(erroLoginMenssage.isEnabled());
	}
}
