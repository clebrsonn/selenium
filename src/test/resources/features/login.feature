  # language: pt
  @ContaTeste
  Funcionalidade: Testar as operacoes basicas do sistema


    Cenario: Não é possível criar uma pasta nova
      Dado eu vou a pagina de "Menu Editor"
      Quando A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "new folder modal"
      Quando o elemento "new folder modal" carregar
#      E eu preencher o campo "folder name" com o valor "testes"
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
      E eu seleciono o valor "Almoxarifado" no "folder directory" combobox
      E eu preencher o campo "folder name" com o valor "testes"
      E o elemento "botão salvar" estiver "ativo"
      E eu clicar no "botão salvar"
      E eu espero o elemento "new folder modal" ficar "invisivel"
      E o elemento "new folder modal" está "invisivel"
      Quando eu vou a pagina de "Document List"
#      Quando eu clico duas vezes no valor "testes" na lista "Almoxarifado"
      Quando eu clicar no "Almoxarifado"
      E eu vou a pagina de "Sub Group List"
      Então eu espero o elemento "testes" ficar "visivel"


    Cenario: Editar subGrupo
      Dado eu vou a pagina de "Document List"
      Quando eu clicar no "Almoxarifado"
      E eu vou a pagina de "Sub Group List"
      E eu clico duas vezes no elemento "testes"
      E eu preencher o campo "input folder name" com o valor "cleberson"
      E eu clicar no "confirm button"
      E o valor do elemento na posição "1" for igual à "cleberson"
      Então o elemento "<string>" carregar
      #Então a notificação de sucesso com o texto "" aparece

