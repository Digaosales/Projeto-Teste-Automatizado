package stepdefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageobjects.LoginPage;
import utils.DriverUtils;

public class LoginSteps {

	public static WebDriver driver;

	LoginPage lp;

	@Dado("^que o usuario esteja na pagina de login do gerenciador de produtos$")
	public void que_o_usuario_esteja_na_pagina_de_login_do_gerenciador_de_produtos() throws Throwable {
		lp = new LoginPage(DriverUtils.getDriver());
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

	}

	@Entao("^o sistema devera apresentar mensagem de erro$")
	public void o_sistema_devera_apresentar_mensagem_de_erro() throws Throwable {
		lp.validarMensagemDeErroDeLogin();
	}

}
