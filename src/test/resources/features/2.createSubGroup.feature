  # language: pt
  @ContaTeste
  Funcionalidade: Testar as operacoes de criação. edição e rmeoção de "pastas" do sistema

    Cenario: Criar um Grupo
      Dado eu vou a pagina de "Menu Editor"
      Quando A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "New Folder"
      Quando o elemento "new folder modal" carregar
      E eu seleciono o valor "Almoxarifado" no "folder directory" combobox
      E eu preencher o campo "folder name" com o valor "testes"
      E o elemento "botão salvar" estiver "ativo"
      E eu clicar no "botão salvar"
      E eu espero o elemento "new folder modal" ficar "invisivel"
      E o elemento "new folder modal" está "invisivel"
      Quando eu vou a pagina de "Document List"
      Quando eu clicar no "Almoxarifado"
      E eu vou a pagina de "Sub Group List"
      Então eu espero o elemento "testes" ficar "visivel"
      E eu vou a pagina de "Home"
      Então o elemento "notification success" está "visivel"




    Cenario: Não é possível criar uma pasta nova
      Dado eu vou a pagina de "Menu Editor"
      Quando A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "New Folder"
      Quando o elemento "new folder modal" carregar
      E eu seleciono o valor "Almoxarifado" no "folder directory" combobox
      Então o elemento "botão salvar" estiver "inativo"
      E o elemento "new folder modal" está "visivel"


    Cenario: Criar um sub-grupo
      Dado eu vou a pagina de "Menu Editor"
      Quando A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "New Folder"
      Quando o elemento "new folder modal" carregar
      E eu seleciono o valor "Almoxarifado" no "folder directory" combobox
      E eu preencher o campo "folder name" com o valor "testes"
      E o elemento "botão salvar" estiver "ativo"
      E eu clicar no "botão salvar"
      E eu espero o elemento "new folder modal" ficar "invisivel"
      E o elemento "new folder modal" está "invisivel"
      Quando eu vou a pagina de "Document List"
      Quando eu clicar no "Almoxarifado"
      E eu vou a pagina de "Sub Group List"
      Então eu espero o elemento "testes" ficar "visivel"
      E eu vou a pagina de "Home"
      Então o elemento "notification success" está "visivel"


    Cenario: Editar subGrupo
      Dado eu vou a pagina de "Document List"
      Quando eu clicar no "Almoxarifado"
      E eu vou a pagina de "Sub Group List"
      E eu clico duas vezes no elemento da posição "2"
      E eu preencher o campo "input folder name" com o valor "cleberson"
      E eu clicar no "confirm button"
      E eu vou a pagina de "Home"
      Então o elemento "notification success" está "visivel"

#      Então o valor do elemento na posição "2" é igual à "cleberson"

    Cenario: Remover subGrupo
      Dado eu vou a pagina de "Document List"
      Quando eu clicar no "Almoxarifado"
      E eu vou a pagina de "Sub Group List"
      E o valor do elemento na posição "2" é igual à "cleberson"
      E eu clico duas vezes no elemento da posição "2"
      E o elemento "input folder name" está "visivel"
      E eu clicar no "remove button"
      Então o elemento com o valor "cleberson" "nao existe" na lista "sub group"


