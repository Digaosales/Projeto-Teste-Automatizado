package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverUtils;
import utils.MethodsUtils;

public class ProductPage {

	protected WebDriver driver;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@href='/product']")
	private WebElement menuProduct;

	@FindBy(id = "tabs-produtos-tab-cadastrar-produto")
	private WebElement subMenuCadastrar;

	@FindBy(id = "title")
	private WebElement campoNomeProduto;

	@FindBy(id = "order")
	private WebElement campoOrder;

	@FindBy(id = "teste")
	private WebElement apresentacaoProduto;

	@FindBy(id = "discount")
	private WebElement descricaoAdicional;

	@FindBy(xpath = ("//span[@class = 'switch-off btn btn-light']"))
	private WebElement btnLiquidecora;

	@FindBy(id = " description")
	private WebElement completeDescription;

	@FindBy(id = "linkWpp")
	private WebElement campolinkWpp;

	@FindBy(id = "toggle-button")
	private WebElement menuButton;

	@FindBy(id = "text-menu-item")
	private List<WebElement> selectButton;

	@FindBy(id = "images")
	private WebElement sendImages;

	@FindBy(xpath = ("//select[@class = 'form-control']"))
	private WebElement selectStore;

	@FindBy(id = "categoria1")
	private WebElement selectCategoria;

	@FindBy(id = "subcategoria1")
	private WebElement selectSubCategoria;

	@FindBy(xpath = ("//button[@type = 'submit']"))
	private WebElement btnCadastrar;

	@FindBy(css = "tr:last-child td:nth-child(2)")
	private WebElement novoProduto;

	@FindBy(css = "div.button-addon2 button")
	private WebElement btnNovoBotao;

	@FindBy(id = "formBasicText")
	private WebElement campoNomeBotao;

	@FindBy(css = "div.modal-footer button:nth-last-of-type(1)")
	private WebElement btnCadastrarNovoBotao;

	@FindBy(css = "tr:last-child td:last-child div:nth-of-type(2) a")
	private WebElement btnRemover;

	@FindBy(css = "tr:last-child td:last-child div:nth-of-type(1) a")
	private WebElement btnEditar;

	@FindBy(css = "#formBasicEmail")
	private WebElement editarDescricaoCompleta;

	public void acessarMenuProdutos() {
		MethodsUtils.esperarElemento(menuProduct);
		menuProduct.click();
	}

	public void acessarSubMenuCadastrar() {
		MethodsUtils.esperarElemento(subMenuCadastrar);
		subMenuCadastrar.click();
	}

	public void preencherNomeProduto() {
		MethodsUtils.esperarElemento(campoNomeProduto);
		campoNomeProduto.sendKeys("Sofa Max Plus");
	}

	public void preencherOrder() {
		MethodsUtils.esperarElemento(campoOrder);
		campoOrder.clear();
		campoOrder.sendKeys("0");
	}

	public void preencherSelecaoDoProduto() {
		MethodsUtils.esperarElemento(apresentacaoProduto);
		MethodsUtils.selecionar(apresentacaoProduto, "preço sob consulta");

	}

	public void preencherDescricao() {
		MethodsUtils.esperarElemento(descricaoAdicional);
		descricaoAdicional.sendKeys("Sofa de couro");
	}

	public void ativarLiquidecora() {
		MethodsUtils.esperarElemento(btnLiquidecora);
		btnLiquidecora.click();
	}

	public void preencherDescricaoCompleta() {
		MethodsUtils.esperarElemento(completeDescription);
		completeDescription.sendKeys("Sofa de couro Marron com costura em branco");
	}

	public void preencherlinkWpp() {
		MethodsUtils.esperarElemento(campolinkWpp);
		campolinkWpp.clear();
		campolinkWpp.sendKeys("https://api.whatsapp.com/send?phone=5561985202222");
	}

	public void openMenuButton() {
		MethodsUtils.esperarElemento(menuButton);
		menuButton.click();

	}

	public void selecionarbotao() {
		WebElement botao11 = null;
		for (int i = 0; i < selectButton.size(); i++) {
			if (selectButton.get(i).getText().contains("botão 11")) {
				botao11 = selectButton.get(i);
			}
		}
		MethodsUtils.esperarElemento(botao11);
		botao11.click();
	}

	public void uploadImages() {
		MethodsUtils.esperarElemento(sendImages);
		sendImages.sendKeys("C:\\Sofadecouro.jpg");

	}

	public void preencherLoja() {
		MethodsUtils.esperarElemento(selectStore);
		MethodsUtils.selecionar(selectStore, "salva");

	}

	public void preencherCategoriaDoProduto() {
		MethodsUtils.esperarElemento(selectCategoria);
		MethodsUtils.selecionar(selectCategoria, "sala");

	}

	public void preencherSubCategoriaDoProduto() {
		MethodsUtils.esperarElemento(selectSubCategoria);
		MethodsUtils.selecionar(selectSubCategoria, "sofás");

	}

	public void btnCadastrarNovoProduto() {
		MethodsUtils.esperarElemento(btnCadastrar);
		btnCadastrar.click();
	}

	public void validarAlertProduct() {
		try {
			Thread.sleep(500);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals("Produto cadastrado com sucesso!", alertText);
			assertTrue(alertText.equals("Produto cadastrado com sucesso!"));
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validarNovoProduto() {
		MethodsUtils.esperarElemento(novoProduto);
		assertEquals(novoProduto.getText(), "Sofa Max Plus");
	}

	public void btnNovoNomeBotao() {
		MethodsUtils.esperarElemento(btnNovoBotao);
		btnNovoBotao.click();

	}

	public void preencherNomeNovoBotao(String arg1) {
		MethodsUtils.esperarElemento(campoNomeBotao);
		campoNomeBotao.sendKeys(arg1);

	}

	public void cadastrarNovoNomeDeBotao() {
		MethodsUtils.esperarElemento(btnCadastrarNovoBotao);
		btnCadastrarNovoBotao.click();
	}

	public void validarAlertDeNovoBotao() {
		try {
			Thread.sleep(500);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals("Botão cadastrado com sucesso!", alertText);
			assertTrue(alertText.equals("Botão cadastrado com sucesso!"));
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validarNovoBotao(String arg1) {
		WebElement botaoTeste = null;
		for (int i = 0; i < selectButton.size(); i++) {
			if (selectButton.get(i).getText().contains(arg1)) {
				botaoTeste = selectButton.get(i);
			}
		}
		assertTrue("Botão Cadastrado não foi encontrado", botaoTeste != null);
		MethodsUtils.esperarElemento(botaoTeste);
		assertEquals("Botao divergente", "Botao Teste", botaoTeste.getText());

	}

	public void btnRemoverProduto() {
		MethodsUtils.esperarElemento(btnRemover);
		btnRemover.click();
	}

	public void comfirmarAlertRemoverProduto() {
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

	public void validarAlertDeProdutoRemovido() {
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

	public void validarExclusaoDoProduto(String arg1) throws InterruptedException {
		Thread.sleep(1000);
		WebElement nomeExcluido = DriverUtils.getDriver().findElement(By.cssSelector("tr:last-child td:nth-child(2)"));
		assertNotEquals(nomeExcluido.getText(), arg1);
	}

	public void btnEditarProduto() {
		MethodsUtils.esperarElemento(btnEditar);
		btnEditar.click();
	}

	public void preencherEdicaoDoProduto() {
		campoNomeProduto.clear();
		campoNomeProduto.sendKeys("Sofa Simples Comfort");
		descricaoAdicional.clear();
		descricaoAdicional.sendKeys("Sofa de suede Macio na cor beje");
		btnLiquidecora.click();
		editarDescricaoCompleta.clear();
		editarDescricaoCompleta.sendKeys("Sofa fino feito por desing italiano");
		MethodsUtils.selecionar(selectStore, "salva");
		MethodsUtils.selecionar(selectCategoria, "quarto");
		MethodsUtils.selecionar(selectSubCategoria, "camas");

	}

	public void validarAlertDeProdutoEditado() {
		try {
			Thread.sleep(500);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertEquals("Produto editado com sucesso!", alertText);
			assertTrue(alertText.equals("Produto editado com sucesso!"));
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validarProdutoEditado(String arg1) {
		MethodsUtils.esperarElemento(novoProduto);
		assertEquals(novoProduto.getText(), arg1);
	}

}
