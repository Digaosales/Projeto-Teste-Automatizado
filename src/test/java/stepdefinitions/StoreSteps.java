package stepdefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageobjects.LoginPage;
import pageobjects.StorePage;
import utils.DriverUtils;

public class StoreSteps {

	StorePage sp;
	LoginPage lp;
	
	@Dado("^que o usuario esteja na pagina principal ou na home apos o login$")
	public void que_o_usuario_esteja_na_pagina_principal_ou_na_home_apos_o_login() throws Throwable {
		lp = new LoginPage(DriverUtils.getDriver());
		lp.preencherUsuario("rodrigo");
		lp.preencherSenha("123456");
		lp.clicaBotaoLogin();
		sp = new StorePage(DriverUtils.getDriver());

	}

	@Quando("^clicar na opcao lojas em navbar menu$")
	public void clicar_na_opcao_lojas_em_navbar_menu() throws Throwable {
		sp.acessarMenuLojas();

	}

	@Quando("^clicar na opcao Cadastrar apresentada no submenu$")
	public void clicar_na_opcao_Cadastrar_apresentada_no_submenu() throws Throwable {
		sp.acessarMenuCadastrarLojas();
	}

	@Quando("^informar o nome da loja a ser criado \"([^\"]*)\"$")
	public void informar_o_nome_da_loja_a_ser_criado(String arg1) throws Throwable {
		sp.preencherNovoNomeDeLoja(arg1);
	}

	@Quando("^clicar no botao Cadastrar para inserir nova loja$")
	public void clicar_no_botao_Cadastrar_para_inserir_nova_loja() throws Throwable {
		sp.cadastrarNovaLoja();
	}

	@Entao("^o sistema devera apresentar a mensagem de cadastramento com sucesso$")
	public void o_sistema_devera_apresentar_a_mensagem_de_cadastramento_com_sucesso() throws Throwable {
		sp.validarAlert();
	}

	@Entao("^o sistema incluira o nome \"([^\"]*)\" criado na lista de lojas existente$")
	public void o_sistema_incluira_o_nome_criado_na_lista_de_lojas_existente(String arg1) throws Throwable {
		sp.mostrarMenuComListaDeLojas();
		sp.validaNovaLoja(arg1);
	
	}

	@Entao("^o sistema devera apresentar a mensagem de preenchimento obrigatorio$")
	public void o_sistema_devera_apresentar_a_mensagem_de_preenchimento_obrigatorio() throws Throwable {
		sp.validarAlertDePreenchimentoObrigatrio();
		
	}

	@Quando("^clicar no botao editar referente a loja que deseja alterar o nome$")
	public void clicar_no_botao_editar_referente_a_loja_que_deseja_alterar_o_nome() throws Throwable {
		sp.btnEditarNomeDaLoja();
	}

	@Quando("^informar o novo nome \"([^\"]*)\" para alteracao$")
	public void informar_o_novo_nome_para_alteracao(String arg1) throws Throwable {
		sp.preencherNovoNomeDeLoja(arg1);
	}

	@Entao("^o sistema devera apresentar a mensagem editado com sucesso$")
	public void o_sistema_devera_apresentar_a_mensagem_editado_com_sucesso() throws Throwable {
		sp.validarAlertDeEditarNome();
	}

	@Entao("^o sistema incluira o nome \"([^\"]*)\" editado com sucesso na lista de lojas existente$")
	public void o_sistema_incluira_o_nome_editado_com_sucesso_na_lista_de_lojas_existente(String arg1)
			throws Throwable {
		sp.validaNovaLoja(arg1);
	}

	@Quando("^clicar no botao Remover referente a loja que deseja excluir$")
	public void clicar_no_botao_Remover_referente_a_loja_que_deseja_excluir() throws Throwable {
		sp.btnRemoverLoja();
	}

	@Quando("^clicar no botao para confirmar a exclusao da loja$")
	public void clicar_no_botao_para_confirmar_a_exclusao_da_loja() throws Throwable {
		sp.confirmarRemocaoDaLoja();
	}

	@Quando("^clicar no botao de confirmacao de loja excluida$")
	public void clicar_no_botao_de_confirmacao_de_loja_excluida() throws Throwable {
		sp.confirmacaoDeLojaRemovida();
	}

	@Entao("^o sistema removera  loja da lista de lojas existente$")
	public void o_sistema_removera_loja_da_lista_de_lojas_existente() throws Throwable {
		sp.validarRemocaoDoNomeDaloja();
	}

	@Quando("^informar o nome de uma loja \"([^\"]*)\" ja existente na lista de lojas criadas$")
	public void informar_o_nome_de_uma_loja_ja_existente_na_lista_de_lojas_criadas(String arg1) throws Throwable {
		sp.preencherNovoNomeDeLoja(arg1);
	}

	@Entao("^o sistema devera apresentar a mensagem de loja ja cadastrada$")
	public void o_sistema_devera_apresentar_a_mensagem_de_loja_ja_cadastrada() throws Throwable {
		sp.validarMensagemDeLojaJaCriada();
	}

}
