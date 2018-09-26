  # language: pt
  @DocumentTest
  Funcionalidade: Testar as operacoes de criação. edição e rmeoção de "pastas" do sistema


    Esquema do Cenario: Criar uma nova subpasta
      Dado eu vou a pagina de "Login"
      E eu preencher o campo "username field" com o valor "<user>"
      E eu preencher o campo "password field" com o valor "<user>"
      E eu clicar no "login button"
      Quando eu vou a pagina de "Menu Editor"
      E A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "New Folder"
      Quando o elemento "new folder modal" carregar
      E eu preencher o campo "folder name" com o valor "<grupo>"
      E eu seleciono o valor "Raiz" no "folder directory" combobox
      E o elemento "botão criar" estiver "ativo"
      E eu clicar no "botão criar"
      E eu espero o elemento "new folder modal" ficar "invisivel"
      E o elemento "new folder modal" está "invisivel"
      E o elemento "notification success" está "visivel"
      E o texto do elemento "notification title" for igual à "Sucesso"
      E o texto do elemento "notification description" for igual à "A pasta foi criada."
      E eu vou a pagina de "Group List"
      E o elemento com o valor "<grupo>" "existe" na lista "Group List"
      Quando eu vou a pagina de "Menu Editor"
      E A página "Menu Editor" carregar
      E eu clicar no "botão Nova Pasta"
      E eu vou a pagina de "New Folder"
      Quando o elemento "new folder modal" carregar
      E eu preencher o campo "folder name" com o valor "<subgrupo>"
      E eu seleciono o valor "<grupo>" no "folder directory" combobox
      E o elemento "botão criar" estiver "ativo"
      E eu clicar no "botão criar"
      E eu espero o elemento "new folder modal" ficar "invisivel"
      E o elemento "new folder modal" está "invisivel"
      Quando o elemento "notification success" está "visivel"
      E o texto do elemento "notification title" for igual à "Sucesso"
      E o texto do elemento "notification description" for igual à "A pasta foi criada."
      Quando eu vou a pagina de "Group List"
      E eu clicar no "<grupo>"
      E eu vou a pagina de "Sub Group List"
      Então eu espero o elemento "<subgrupo>" ficar "visivel"


      Exemplos:
        | user  | grupo             | subgrupo              |
        | dbamv | Doc Teste Sprint  | Teste doc Sprint      |
        | dbamv | Doc Teste Sprint2 | Sub Doc Teste Sprint2 |

    Esquema do Cenario: Criar um documento
      Dado eu vou a pagina de "Login"
      E eu preencher o campo "username field" com o valor "<user>"
      E eu preencher o campo "password field" com o valor "<user>"
      E eu clicar no "login button"
      Dado eu vou a pagina de "Group List"
      E eu clicar no "<grupo>"
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


      Exemplos:
        | user  | grupo             | subgrupo              |
        | dbamv | Doc Teste Sprint  | Teste doc Sprint      |
        | dbamv | Doc Teste Sprint2 | Sub Doc Teste Sprint2 |


#
#      E eu seleciono o valor "Almoxarifado" no "folder directory" combobox
#      E eu preencher o campo "folder name" com o valor "testes"
#      E o elemento "botão salvar" estiver "ativo"
#      E eu clicar no "botão salvar"
#      E eu espero o elemento "new folder modal" ficar "invisivel"
#      E o elemento "new folder modal" está "invisivel"
#      Quando eu vou a pagina de "Document List"
#      Quando eu clicar no "Almoxarifado"
#      E eu vou a pagina de "Sub Group List"
#      Então eu espero o elemento "testes" ficar "visivel"
#      E eu vou a pagina de "Home"
#      Então o elemento "notification success" está "visivel"


    Esquema do Cenario:
      Dado eu vou a pagina de "Login"
      E eu preencher o campo "username field" com o valor "<user>"
      E eu preencher o campo "password field" com o valor "<user>"
      E eu clicar no "login button"

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

      Exemplos:
        | user  | grupo             | subgrupo              |
        | dbamv | Doc Teste Sprint  | Teste doc Sprint      |
        | dbamv | Doc Teste Sprint2 | Sub Doc Teste Sprint2 |


    Esquema do Cenario: Copiar/Colar Documento
      Dado eu vou a pagina de "Login"
      E eu preencher o campo "username field" com o valor "<user>"
      E eu preencher o campo "password field" com o valor "<user>"
      E eu clicar no "login button"
      Dado eu vou a pagina de "Group List"
      Quando A página "Group List" carregar
      Quando eu clicar no "<grupo>"
      E eu clicar no "<subgrupo>"
      Quando eu vou a pagina "Group List"
      E eu clicar no "7 - Evolução"
      Dado eu vou a pagina de "Menu Editor"
      E o elemento "botão copiar" estiver "ativo"
      E eu clico no "botão copiar"
      Dado eu vou a pagina de "Group List"
      E eu clico no "Urgência e Emergência"
      E eu vou a pagina de "Sub Group List"
      Dado eu vou a pagina de "Menu Editor"
      E o elemento "botão colar" estiver "ativo"
      E eu clico no "botão colar"
      Então o elemento "notification sucess" está "visivel"
      Então o texto do elemento "notification description" for igual à "Documento copiado com sucesso."


      Exemplos:
        | user  | grupo             | subgrupo              |
        | dbamv | Doc Teste Sprint  | Teste doc Sprint      |
        | dbamv | Doc Teste Sprint2 | Sub Doc Teste Sprint2 |