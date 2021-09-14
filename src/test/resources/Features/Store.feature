#language:pt
@End2End
@ScreenTest
Funcionalidade: Store

  Contexto: 
    Dado que o usuario esteja na pagina principal ou na home apos o login
  
  Cenario: cadastrar uma nova loja com sucesso
    Quando clicar na opcao lojas em navbar menu
    E clicar na opcao Cadastrar apresentada no submenu
    E informar o nome da loja a ser criado "loja teste"
    E clicar no botao Cadastrar para inserir nova loja
    Entao o sistema devera apresentar a mensagem de cadastramento com sucesso
    E o sistema incluira o nome "loja teste" criado na lista de lojas existente
   
  Cenario: erro ao cadastrar nova loja sem informar o nome
    Quando clicar na opcao lojas em navbar menu
    E clicar na opcao Cadastrar apresentada no submenu
    E informar o nome da loja a ser criado ""
    E clicar no botao Cadastrar para inserir nova loja
    Entao o sistema devera apresentar a mensagem de preenchimento obrigatorio
    
  Cenario: editar nome da loja ja criada
    Quando clicar na opcao lojas em navbar menu
    E clicar no botao editar referente a loja que deseja alterar o nome
    E informar o novo nome "Americanas" para alteracao
    E clicar no botao Cadastrar para inserir nova loja
    Entao o sistema devera apresentar a mensagem editado com sucesso
    E o sistema incluira o nome "Americanas" editado com sucesso na lista de lojas existente

  Cenario: remover loja ja criada
    Quando clicar na opcao lojas em navbar menu
    E clicar no botao Remover referente a loja que deseja excluir
    E clicar no botao para confirmar a exclusao da loja
    E clicar no botao de confirmacao de loja excluida
    Entao o sistema removera  loja da lista de lojas existente
  
  Cenario: erro ao cadastrar loja com nome ja existente
    Quando clicar na opcao lojas em navbar menu
    E clicar na opcao Cadastrar apresentada no submenu
    E informar o nome de uma loja "salva" ja existente na lista de lojas criadas
    E clicar no botao Cadastrar para inserir nova loja
    Entao o sistema devera apresentar a mensagem de loja ja cadastrada
 
  Cenario: editar nome da loja ja criada por um nome ja existente na lista de lojas
    Quando clicar na opcao lojas em navbar menu
    E clicar no botao editar referente a loja que deseja alterar o nome
    E informar o nome de uma loja "salva" ja existente na lista de lojas criadas
    E clicar no botao Cadastrar para inserir nova loja
    Entao o sistema devera apresentar a mensagem de loja ja cadastrada
