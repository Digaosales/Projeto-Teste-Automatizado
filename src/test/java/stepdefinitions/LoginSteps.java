package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageobjects.LoginPage;

public class LoginSteps {

	public static WebDriver driver;
	
	LoginPage lp;
	

	@Dado("^que o usuario esteja na pagina de login do gerenciador de produtos$")
	public void que_o_usuario_esteja_na_pagina_de_login_do_gerenciador_de_produtos() throws Throwable {
		System.setProperty("WebDriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:3001");
	}

	@Quando("^informar o campo de login como \"([^\"]*)\"$")
	public void informar_o_campo_de_login_como(String arg1) throws Throwable {
       lp.preencherUsuario(arg1);
	}

	@Quando("^informar o campo de senha como \"([^\"]*)\"$")
	public void informar_o_campo_de_senha_como(String arg1) throws Throwable {
		lp.preencherSenha(arg1);
	}

	@Quando("^clicar no botao entrar$")
	public void clicar_no_botao_entrar() throws Throwable {
		lp.clicaBotaoLogin();
	}

	@Entao("^o sistema devera autorizar o login exibindo a pagina de navegacao dos produtos\\.$")
	public void o_sistema_devera_autorizar_o_login_exibindo_a_pagina_de_navegacao_dos_produtos() throws Throwable {
		lp.validarGerenciadorDeProdutos();
		driver.close();
		
	}
	@Entao("^o sistema devera apresentar mensagem de erro$")
	public void o_sistema_devera_apresentar_mensagem_de_erro() throws Throwable {
	 lp.validarMensagemDeErroDeLogin();
	 driver.close();
	}

}
