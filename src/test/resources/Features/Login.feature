#language:pt

Funcionalidade: Login

  Contexto: 
    Dado que o usuario esteja na pagina de login do gerenciador de produtos


  Cenario: realizar login com sucesso
    Quando informar o campo de login como "rodrigo"
    E informar o campo de senha como "123456"
    E clicar no botao entrar
    Entao o sistema devera autorizar o login exibindo a pagina de navegacao dos produtos.
  
  Cenario: erro ao logar com usuario diferente e a senha correta
    Quando informar o campo de login como "romulo"
    E informar o campo de senha como "123456"
    E clicar no botao entrar
    Entao o sistema devera apresentar mensagem de erro 

  Cenario: erro ao tentar logar com usuario correto e a senha errada
    Quando informar o campo de login como "rodrigo"
    E informar o campo de senha como "1234567"
    E clicar no botao entrar
    Entao o sistema devera apresentar mensagem de erro

  Cenario: erro ao tentar logar sem usuario e senha.
    Quando informar o campo de login como ""
    E informar o campo de senha como ""
    E clicar no botao entrar
    Entao o sistema devera apresentar mensagem de erro

  Cenario: erro ao tentar logar com nome de usuario com a primeira letra maiuscula
    Quando informar o campo de login como "Rodrigo"
    E informar o campo de senha como "123456"
    E clicar no botao entrar
    Entao o sistema devera apresentar mensagem de erro

  Cenario: erro ao tentar logar com usuario em maiusculo e senha correta.
    Quando informar o campo de login como "RODRIGO"
    E informar o campo de senha como "123456"
    E clicar no botao entrar
    Entao o sistema devera apresentar mensagem de erro

  Cenario: erro ao tentar logar com senha com CAPS LOCK ativado.
    Quando informar o campo de login como "romulo"
    E informar o campo de senha como "SOL123"
    E clicar no botao entrar
    Entao o sistema devera apresentar mensagem de erro
