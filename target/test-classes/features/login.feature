  # language: pt
  @ContaTeste
  Funcionalidade: Testar as operacoes basicas do sistema


    Cenario: Criar uma pasta nova
      Dado eu vou a pagina de "Menu Editor"
      Quando A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "new folder modal"
      Quando o elemento "new folder modal" carregar
      E eu seleciono o valor "Almoxarifado" no "folder directory" combobox
      E o elemento "botão salvar" estiver "inativo"
      Então o elemento "new folder modal" está "visivel"

#      Quando eu clicar no "botão salvar"
#      Entao eu vou a pagina de "Document List"
#      Quando eu seleciono o valor "Almoxarifado" na lista "Almoxarifado"


#
#    Cenario: Crio uma pasta nova
#      Dado eu vou a pagina de "Document List"
#      Quando eu seleciono o valor "Evolução Nutrição" na lista "Documentos Assistenciais"


    Cenario: Criar uma pasta nova
      Dado eu vou a pagina de "Menu Editor"
      Quando A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "new folder modal"
      Quando o elemento "new folder modal" carregar
      E eu preencher o campo "folder name" com o valor "testes"
      E eu seleciono o valor "Almoxarifado" no "folder directory" combobox
      E o elemento "botão salvar" estiver "ativo"
      E eu clicar no "botão salvar"
      Então o elemento "new folder modal" está "invisivel"
      E eu vou a pagina de "Document List"
      Quando eu seleciono o valor "testes" na lista "Almoxarifado"
