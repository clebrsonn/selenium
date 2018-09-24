   # language: pt
   @DocumentTest
   Funcionalidade: Testar as operacoes de criação. edição e rmeoção de "pastas" do sistema

     Cenario: Criar uma nova pasta Raiz
       Dado eu vou a pagina de "Menu Editor"
       Quando A página "Menu Editor" carregar
       E eu clicar no "botão Nova Pasta"
       E eu vou a pagina de "New Folder"
       Quando o elemento "new folder modal" carregar
       E eu seleciono o valor "Raiz" no "folder directory" combobox
       E eu preencher o campo "folder name" com o valor "Documentos Teste Sprint"
       E o elemento "botão criar" estiver "ativo"
       E eu clicar no "botão criar"
       E eu espero o elemento "new folder modal" ficar "invisivel"
       E o elemento "new folder modal" está "invisivel"
       E eu vou a pagina de "Notifications"
       Então o elemento "notification success" está "visivel"
       Então o texto do elemento "notification title" for igual à "Sucesso"
       Então o texto do elemento "notification description" for igual à "Grupo salvo com Sucesso."
       Então o elemento com o valor "Documentos Teste Sprint" "existe" na lista "Group List"


     Cenario: Criar uma nova subpasta
       Dado eu vou a pagina de "Menu Editor"
       Quando A página "Menu Editor" carregar
       E eu clicar no "botão Nova Pasta"
       E eu vou a pagina de "New Folder"
       Quando o elemento "new folder modal" carregar
       E eu seleciono o valor "Documentos Teste Sprint" no "folder directory" combobox
       E eu preencher o campo "folder name" com o valor "Subpasta"
       E o elemento "botão criar" estiver "ativo"
       E eu clicar no "botão criar"
       E eu espero o elemento "new folder modal" ficar "invisivel"
       E o elemento "new folder modal" está "invisivel"
       E eu vou a pagina de "Notifications"
       Então o elemento "notification success" está "visivel"
       Então o texto do elemento "notification title" for igual à "Sucesso"
       Então o texto do elemento "notification description" for igual à "Subpasta criada com sucesso."
       Quando eu vou a pagina de "Group List"
       Quando eu clicar no "Documentos Teste Sprint"
       E eu vou a pagina de "Sub Group"
       Então eu espero o elemento "Subpasta" ficar "visivel"


     Cenario: Excluir pasta Raiz com conteúdo
       Dado eu vou a pagina de "Group List"
       Quando A página "Group List" carregar
       E eu clico duas vezes no elemento "Documentos Teste Sprint"
       E eu clicar no "remove button"
       Então o elemento "notification error" está "visivel"
       Então o texto do elemento "notification description" for igual à "Grupo não pode ser deletado. Possui uma ou mais dependências."

     Cenario: Editar Grupo
       Dado eu vou a pagina de "Group List"
       Quando eu clico duas vezes no elemento "Documentos Teste Sprint"
       E eu preencher o campo "input folder name" com o valor "Documentos"
       E eu clicar no "confirm button"
       E eu vou a pagina de "Notifications"
       Então o elemento "notification success" está "visivel"
       Então o texto do elemento "notification title" for igual à "Sucesso"
       Então o texto do elemento "notification description" for igual à "Grupo atualizado com sucesso."







