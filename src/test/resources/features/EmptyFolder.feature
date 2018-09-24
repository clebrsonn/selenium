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
       E eu preencher o campo "folder name" com o valor "Pasta Vazia"
       E o elemento "botão criar" estiver "ativo"
       E eu clicar no "botão criar"
       E eu espero o elemento "new folder modal" ficar "invisivel"
       E o elemento "new folder modal" está "invisivel"
       E eu vou a pagina de "Notifications"
       Então o elemento "notification success" está "visivel"
       Então o texto do elemento "notification title" for igual à "Sucesso"
       Então o texto do elemento "notification description" for igual à "Grupo salvo com Sucesso."
       Então o elemento com o valor "Pasta Vazia" "existe" na lista "Group List"

     Cenario: Excluir pasta Raiz vazia
       Dado eu vou a pagina de "Menu Editor"
       Quando A página "Menu Editor" carregar
       E eu clico duas vezes no elemento "Pasta Vazia"
       E eu clicar no "remove button"
       Então o elemento "notification success" está "visivel"
       Então o texto do elemento "notification description" for igual à "Grupo excluído com sucesso."
       Então o elemento com o valor "Pasta Vazia" "nao existe" na lista "Document List"
