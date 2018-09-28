#language: pt
@GroupTest
@ListTest

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
      | user  | grupo               | subgrupo               |
      | dbamv | Grupo Teste Sprint  | SubGrupo Teste Sprint  |
      | dbamv | Grupo Teste Sprint2 | SubGrupo Teste Sprint2 |

  Esquema do Cenario: Editar subGrupo
    Dado eu vou a pagina de "Login"
    E eu preencher o campo "username field" com o valor "<user>"
    E eu preencher o campo "password field" com o valor "<user>"
    E eu clicar no "login button"
    Dado eu vou a pagina de "Group List"
    Quando eu clicar no "<grupo>"
    E eu vou a pagina de "Sub Group List"
    E eu clico duas vezes no elemento da posição "1"
    E eu preencher o campo "input folder name" com o valor "<subgrupo>"
    E eu clicar no "confirm button"
    E o elemento "confirm button" está "invisivel"
    Então o elemento "notification success" está "visivel"
    E o texto do elemento "notification title" for igual à "Sucesso"
    E o texto do elemento "notification description" for igual à "Grupo atualizado com sucesso."
    Então o valor do elemento na posição "1" é igual à "<subgrupo>"

    Exemplos:
      | user  | grupo               | subgrupo                |
      | dbamv | Grupo Teste Sprint  | SubGrupo Teste Sprint1  |
      | dbamv | Grupo Teste Sprint2 | SubGrupo Teste Sprint21 |

  Esquema do Cenario: Remover subGrupo
    Dado eu vou a pagina de "Login"
    E eu preencher o campo "username field" com o valor "<user>"
    E eu preencher o campo "password field" com o valor "<user>"
    E eu clicar no "login button"
    Dado eu vou a pagina de "Group List"
    Quando eu clicar no "<grupo>"
    E eu vou a pagina de "Sub Group List"
    E o valor do elemento na posição "1" é igual à "<subgrupo>"
    E eu clico duas vezes no elemento da posição "1"
    E o elemento "input folder name" está "visivel"
    E eu clicar no "remove button"
    Então o elemento com o valor "<subgrupo>" "nao existe" na lista "Sub Group List"

    Exemplos:
      | user  | grupo               | subgrupo                |
      | dbamv | Grupo Teste Sprint  | SubGrupo Teste Sprint1  |
      | dbamv | Grupo Teste Sprint2 | SubGrupo Teste Sprint21 |