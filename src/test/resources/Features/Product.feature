#language:pt
@End2End
Funcionalidade: Produto

  Contexto: 
    Dado que o usuario esteja na pagina principal ou na home apos o login

  Cenario: cadastrar um novo produto com sucesso
    Quando clicar na opcao Produtos em navbar menu
    E clicar no submenu Cadastrar
    E informar os dados nescesarios para preenchimento do formulario
    E clicar em cadastrar ao final do formulario
    Entao o sistema ira apresentar mensagem de cadastramento com sucesso
    E incluira o produto na lista de produtos

  Cenario: Cadastrar um botao com sucesso
    Quando clicar na opcao Produtos em navbar menu
    E clicar no submenu Cadastrar
    E clicar no botao de adicionar novo botao
    E informa o novo nome do Botao "Botao Teste"
    E clicar no botao de cadastrar
    Entao sistema ira apresentar mensagem de cadastramento de botao com sucesso
    E incluira o botao "Botao Teste" na lista de botoes disponiveis

  Cenario: Alterar um produto
    Quando clicar na opcao Produtos em navbar menu
    E clicar no botao editar
    E informa os dados que deseja alterar
    E clicar no botao cadastrar
    Entao o sistema ira apresentar mensagem de produto editado com sucesso
    E incluira o produto "Sofa Simples Comfort" editado na lista de produtos

  Cenario: Remover um produto
    Quando clicar na opcao Produtos em navbar menu
    E clicar no botao remover
    E clicar no botao OK de confirmacao de remocao
    Entao o sistema ira apresentar mensagem de exclusao com sucesso
    E o sistema ira retirar o produto "Sofa Max Plus" da lista de produtos disponiveis
