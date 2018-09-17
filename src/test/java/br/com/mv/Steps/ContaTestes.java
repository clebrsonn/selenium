package br.com.mv.Steps;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.ListElements;
import cucumber.api.PendingException;
import cucumber.api.java.pt.*;
import org.junit.Assert;


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
    public void euSelecionoOValorNoCombobox(String arg0, String arg1) throws InterruptedException {

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
    public void euSelecionoNaLista(String arg0, String arg1) {

        ((ListElements) page).selectValueInList(arg1, arg0);
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

    @E("^eu espero o elemento \"([^\"]*)\" ficar \"(visivel|invisivel)\"$")
    public void euEsperoOElementoFicar(String element, String condition) {
        // Write code here that turns the phrase above into concrete actions
        page.isVisible(element, condition);
    }

    @Quando("^eu clico duas vezes no elemento \"(.*)\"$")
    public void euClicoDuasVezesNoElemento(String element) {
        page.doubleClick(element);
    }

    @Quando("^eu clico duas vezes no valor \"([^\"]*)\" na lista \"([^\"]*)\"$")
    public void euClicoDuasVezesNoValorNaLista(String value, String list) {
        ((ListElements) page).doubleClickInList(list, value);
    }

    @E("^o valor do elemento \"(.*)\" for igual à \"(.*)\"$")
    public void oValorDoElementoForIgualÀ(String element, String condition) {
        Assert.assertEquals(page.readText(element), condition);
    }

    @E("^o valor do elemento na posição \"([^\"]*)\" for igual à \"([^\"]*)\"$")
    public void oValorDoElementoNaPosiçãoForIgualÀ(int position, String condition) {
        ((ListElements) page).selectValueInListByPosition(position, condition);

    }
}