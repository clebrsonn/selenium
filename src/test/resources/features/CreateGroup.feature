   # language: pt
   @GroupTest
   @ListTest
   Funcionalidade: Testar as operacoes de criação. edição e rmeoção de "pastas" do sistema

     Esquema do Cenario: Criar uma nova pasta Raiz
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
       Então o elemento com o valor "<grupo>" "existe" na lista "Group List"

       Exemplos:
         | user  | grupo                  |
         | dbamv | Documento Teste Sprint |
#         | dbamv | Ducumento Teste Sprint2 |


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
       E eu seleciono o valor "<grupo>" no "folder directory" combobox
       E eu preencher o campo "folder name" com o valor "<subgrupo>"
       E o elemento "botão criar" estiver "ativo"
       E eu clicar no "botão criar"
       E eu espero o elemento "new folder modal" ficar "invisivel"
       E o elemento "new folder modal" está "invisivel"
       Então o elemento "notification success" está "visivel"
       Então o texto do elemento "notification title" for igual à "Sucesso"
       Então o texto do elemento "notification description" for igual à "A subpasta foi criada."
       Quando eu vou a pagina de "Group List"
       Quando eu clicar no "<grupo>"
       E eu vou a pagina de "Sub Group List"
       Então eu espero o elemento "<subgrupo>" ficar "visivel"

       Exemplos:
         | user  | grupo                  | subgrupo     |
         | dbamv | Documento Teste Sprint | Teste Sprint |
#         | dbamv | Ducumento Teste Sprint2 | Teste Sprint2 |


     Esquema do Cenario: Excluir pasta Raiz com conteúdo
       Dado eu vou a pagina de "Login"
       E eu preencher o campo "username field" com o valor "<user>"
       E eu preencher o campo "password field" com o valor "<user>"
       E eu clicar no "login button"
       Quando eu vou a pagina de "Group List"
       E A página "Group List" carregar
       E eu clico duas vezes no elemento "<grupo>"
       E eu clicar no "remove button"
       Então o elemento "notification error" está "visivel"
       Então o texto do elemento "notification description" for igual à "Grupo não pode ser deletado. Possui uma ou mais dependências."

       Exemplos:
         | user  | grupo                  |
         | dbamv | Documento Teste Sprint |
#         | dbamv | Ducumento Teste Sprint2 |


     Esquema do Cenario: Editar Grupo
       Dado eu vou a pagina de "Login"
       E eu preencher o campo "username field" com o valor "<user>"
       E eu preencher o campo "password field" com o valor "<user>"
       E eu clicar no "login button"
       Dado eu vou a pagina de "Group List"
       Quando eu clico duas vezes no elemento "<grupo>"
       E eu preencher o campo "input folder name" com o valor "<novo_nome>"
       E eu clicar no "confirm button"
       Então o elemento "notification success" está "visivel"
       Então o texto do elemento "notification title" for igual à "Sucesso"
       Então o texto do elemento "notification description" for igual à "Grupo atualizado com sucesso."


       Exemplos:
         | user  | grupo                  | novo_nome  |
         | dbamv | Documento Teste Sprint | Documentos |
#         | dbamv | Ducumento Teste Sprint2 | Documentos2 |


     Esquema do Cenario: Não é possível criar uma pasta nova
       Dado eu vou a pagina de "Login"
       E eu preencher o campo "username field" com o valor "<user>"
       E eu preencher o campo "password field" com o valor "<user>"
       E eu clicar no "login button"
       Quando eu vou a pagina de "Menu Editor"
       E A página "Menu Editor" carregar
       E eu clicar no "botão Nova Pasta"
       E eu vou a pagina de "New Folder"
       Quando o elemento "new folder modal" carregar
       E eu seleciono o valor "Raiz" no "folder directory" combobox
       Então o elemento "botão criar" estiver "inativo"
       E o elemento "new folder modal" está "visivel"

       Exemplos:
         | user  |
         | dbamv |

