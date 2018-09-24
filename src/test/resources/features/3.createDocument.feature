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
      Dado eu vou a pagina de "Group List"
      E eu clicar no "Almoxarifado"
      E eu vou a pagina de "Sub Group List"
      E eu clicar no elemento na posição "1" da lista
      Quando eu vou a pagina de "Menu Editor"
      E A página "Menu Editor" carregar
      E eu clicar no "botão novo documento"
      E eu vou a pagina de "New Document"
      Quando o elemento "new document modal" carregar
      E eu clicar no "Em branco"
      E eu clicar no "Documento em branco"
      Quando o elemento "botão próximo" estiver "ativo"
      E eu clicar no "botão próximo"
      E eu vou a pagina de "New Document2"
      Quando o elemento "new document modal2" carregar



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


    Cenário:
      Dado eu vou a pagina de "document list"
      E eu clicar no "Almoxarifado"
      E eu clicar no "Solicitações"
      Dado eu vou a pagina de "view document"
      E eu clicar no "76 - Solicitações estoque"
      Dado eu vou a pagina de "menu editor"
      E eu clicar no "copiar documento"
      E eu clicar no "colar documento"
      Dado eu vou a pagina de "view document"
      Então a quantidade de documentos é igual a "x"


    Cenario: Copiar/Colar Documento
      Dado eu vou a pagina de "Group List"
      Quando A página "Group List" carregar
      Quando eu clicar no "Documentos"
      E eu clicar no "UTI Neonatal"
      Quando eu vou a pagina "Group List"
      E eu clicar no "7 - Evolução"
      E o elemento "botão copiar" estiver "ativo"
      E eu clico no "botão copiar"
      E eu clico no "Urgência e Emergência"
      E o elemento "botão colar" estiver "ativo"
      E eu clico no "botão colar"
      Então o elemento "notification sucess" está "visivel"
      Então o texto do elemento "notification description" for igual à "Documento copiado com sucesso."

