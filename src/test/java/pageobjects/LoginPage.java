package pageobjects;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.MethodsUtils;

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

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement erroLoginMenssage;

	public void preencherUsuario(String nomeUsuario) throws IOException {
		MethodsUtils.esperarElemento(usuario);
		usuario.sendKeys(nomeUsuario);
	}

	public void preencherSenha(String senhaUsuario) {
		MethodsUtils.esperarElemento(senha);
		senha.sendKeys(senhaUsuario);
	}

	public void clicaBotaoLogin() {
		MethodsUtils.esperarElemento(btnLogin);
		btnLogin.click();
	}

	public void validarGerenciadorDeProdutos() {
		MethodsUtils.esperarElemento(navGerenciador);
		assertTrue(navGerenciador.isEnabled());
	}

	public void validarMensagemDeErroDeLogin() {
		try {
			MethodsUtils.esperarElemento(erroLoginMenssage);
			assertTrue(erroLoginMenssage.isEnabled());
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
