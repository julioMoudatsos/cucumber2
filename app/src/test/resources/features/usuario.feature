# language: pt

Funcionalidade: Testar criacao e captura de usuario

  @deletarUsuarioCriado @sanidade2
  Cenario: Cria o usuario na loja
    Quando  crio um usuario
    Entao   o usuario eh salvo no sistema