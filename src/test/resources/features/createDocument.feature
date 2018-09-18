  # language: pt
  @DocumentTest
  Funcionalidade: Testar as operacoes de criação. edição e rmeoção de "pastas" do sistema


    Cenario: Criar uma pasta nova
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

    Cenario: Criar um documento
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

