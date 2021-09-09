package stepdefinitions;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageobjects.ProductPage;
import utils.DriverUtils;

public class ProductSteps {

	ProductPage pp = new ProductPage(DriverUtils.getDriver());

	@Quando("^clicar na opcao Produtos em navbar menu$")
	public void clicar_na_opcao_Produtos_em_navbar_menu() throws Throwable {
		pp.acessarMenuProdutos();
	}

	@Quando("^clicar no submenu Cadastrar$")
	public void clicar_no_submenu_Cadastrar() throws Throwable {
		pp.acessarSubMenuCadastrar();
	}

	@Quando("^informar os dados nescesarios para preenchimento do formulario$")
	public void informar_os_dados_nescesarios_para_preenchimento_do_formulario() throws Throwable {
		pp.preencherNomeProduto();
		pp.preencherOrder();
		pp.preencherSelecaoDoProduto();
		pp.preencherDescricao();
		pp.ativarLiquidecora();
		pp.preencherDescricaoCompleta();
		pp.preencherDescricao();
		pp.preencherlinkWpp();
		pp.openMenuButton();
		pp.selecionarbotao();
		pp.uploadImages();
		pp.preencherLoja();
		pp.preencherCategoriaDoProduto();
		pp.preencherSubCategoriaDoProduto();
	}

	@Quando("^clicar em cadastrar ao final do formulario$")
	public void clicar_em_cadastrar_ao_final_do_formulario() throws Throwable {
		pp.btnCadastrarNovoProduto();
	}

	@Entao("^o sistema ira apresentar mensagem de cadastramento com sucesso$")
	public void o_sistema_ira_apresentar_mensagem_de_cadastramento_com_sucesso() throws Throwable {
		pp.validarAlertProduct();
	}

	@Entao("^incluira o produto na lista de produtos$")
	public void incluira_o_produto_na_lista_de_produtos() throws Throwable {
		pp.validarNovoProduto();

	}

	@Quando("^clicar no botao de adicionar novo botao$")
	public void clicar_no_botao_de_adicionar_novo_botao() throws Throwable {
		pp.btnNovoNomeBotao();
	}

	@Quando("^informa o novo nome do Botao \"([^\"]*)\"$")
	public void informa_o_novo_nome_do_Botao(String arg1) throws Throwable {
		pp.preencherNomeNovoBotao(arg1);
	}

	@Quando("^clicar no botao de cadastrar$")
	public void clicar_no_botao_de_cadastrar() throws Throwable {
		pp.cadastrarNovoNomeDeBotao();
	}

	@Entao("^sistema ira apresentar mensagem de cadastramento de botao com sucesso$")
	public void sistema_ira_apresentar_mensagem_de_cadastramento_de_botao_com_sucesso() throws Throwable {
		pp.validarAlertDeNovoBotao();
	}

	@Entao("^incluira o botao \"([^\"]*)\" na lista de botoes disponiveis$")
	public void incluira_o_botao_na_lista_de_botoes_disponiveis(String arg1) throws Throwable {
		pp.openMenuButton();
		pp.validarNovoBotao(arg1);

	}

	@Quando("^clicar no botao remover$")
	public void clicar_no_botao_remover() throws Throwable {
		pp.btnRemoverProduto();
	}

	@Quando("^clicar no botao OK de confirmacao de remocao$")
	public void clicar_no_botao_OK_de_confirmacao_de_remocao() throws Throwable {
		pp.comfirmarAlertRemoverProduto();
	}

	@Entao("^o sistema ira apresentar mensagem de exclusao com sucesso$")
	public void o_sistema_ira_apresentar_mensagem_de_exclusao_com_sucesso() throws Throwable {
		pp.validarAlertDeProdutoRemovido();
	}

	@Entao("^o sistema ira retirar o produto \"([^\"]*)\" da lista de produtos disponiveis$")
	public void o_sistema_ira_retirar_o_produto_da_lista_de_produtos_disponiveis(String arg1) throws Throwable {
		pp.validarExclusaoDoProduto(arg1);

	}

	@Quando("^clicar no botao editar$")
	public void clicar_no_botao_editar() throws Throwable {
		pp.btnEditarProduto();
	}

	@Quando("^informa os dados que deseja alterar$")
	public void informa_os_dados_que_deseja_alterar() throws Throwable {
		pp.preencherEdicaoDoProduto();
	}

	@Quando("^clicar no botao cadastrar$")
	public void clicar_no_botao_cadastrar() throws Throwable {
		pp.btnCadastrarNovoProduto();
	}

	@Entao("^o sistema ira apresentar mensagem de produto editado com sucesso$")
	public void o_sistema_ira_apresentar_mensagem_de_produto_editado_com_sucesso() throws Throwable {
		pp.validarAlertDeProdutoEditado();
	}

	@Entao("^incluira o produto \"([^\"]*)\" editado na lista de produtos$")
	public void incluira_o_produto_editado_na_lista_de_produtos(String arg1) throws Throwable {
		pp.validarProdutoEditado(arg1);
	}
}
