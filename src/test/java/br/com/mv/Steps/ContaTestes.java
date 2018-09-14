package br.com.mv.Steps;

import br.com.mv.framework.BasePage;
import br.com.mv.page.elements.MenuEditor;
import br.com.mv.page.elements.NewFolderModal;
import cucumber.api.PendingException;
import cucumber.api.java.pt.*;


public class ContaTestes {

    private BasePage page;

    @Dado("^eu vou a pagina de \"(.*)\"$")
    public void queEuVouAPagina(String pageTitle) {

        page = BasePage.getInstance(pageTitle);

//        page.iAmOn(pageTitle);

    }

    @Então("^Eu logo na aplicação$")
    public void euLogoNaAplicacao() {
        // Write code here that turns the phrase above into concrete actions
        // page.getInstance(LoginPage.class).logar();
    }

    @Quando("^eu clicar no \"(.*)\"$")
    public void euClicarNo(String arg0) {
        page.click(arg0);
    }

    @Quando("^o elemento \"(.*)\" carregar$")
    public void oElementoCarregar(String arg0) {
        page.isPresent(arg0);
    }

    @Entao("^eu seleciono o valor \"(.*)\" no \"([^\"]*)\" combobox$")
    public void euSelecionoOValorNoCombobox(String arg0, String arg1) {

//        BasePage.getInstance(NewFolderModal.class).selectValue(arg1, arg0);
        page.selectValue(arg1, arg0);

    }

    @Quando("^A página \"(.*)\" carregar$")
    public void aPaginaCarregar(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        BasePage.getInstance(MenuEditor.class).wait(500);
    }

    @Entao("^eu seleciono o valor \"([^\"]*)\" na lista$")
    public void euSelecionoOValorNaLista(String arg0) {
    }

    @Quando("^eu seleciono o valor \"([^\"]*)\" na lista \"([^\"]*)\"$")
    public void euClicarEmNaLista(String arg0, String arg1) {

        page.selectValueInList(arg1, arg0);
    }


    //Condition equals ativo or inativo
    @Quando("^o elemento \"([^\"]*)\" estiver \"(inativo|ativo)\"$")
    public void oElementoEstiver(String element, String condition) throws Exception {
        page.isActive(element, condition);

    }

    @Então("^o elemento \"(.*)\" está \"(visivel|invisivel)\"$")
    public void ElementoVisivel(String element, String condition) {
        page.isVisible(element, condition);

    }

    @E("^eu preencher o campo \"([^\"]*)\" com o valor \"([^\"]*)\"$")
    public void euPreencherOCampoComOValor(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        page.writeText(arg0, arg1);
    }

    @E("^eu espero o elemento \"([^\"]*)\" ficar \"([^\"]*)\"$")
    public void euEsperoOElementoFicar(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}