package br.com.mv.Steps;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.ListElements;
import br.com.mv.framework.exceptions.BusinessException;
import cucumber.api.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class ContaTestes {


    private BasePage page;

    @Dado("^eu vou a pagina de \"(.*)\"$")
    public void queEuVouAPagina(String pageTitle) {

        page = BasePage.getInstance(pageTitle);

    }

    @Então("^Eu logo na aplicação$")
    public void euLogoNaAplicacao() {
        // Write code here that turns the phrase above into concrete actions
        // page.getInstance(LoginPage.class).logar();
    }

    @Quando("^eu clicar no \"(.*)\"$")
    public void euClicarNo(String element) {
        page.click(element);
    }

    @Quando("^o elemento \"(.*)\" carregar$")
    public void oElementoCarregar(String element) {
        page.isPresent(element);
    }

    @Entao("^eu seleciono o valor \"(.*)\" no \"([^\"]*)\" combobox$")
    public void euSelecionoOValorNoCombobox(String value, String element) {

//        BasePage.getInstance(NewFolderModal.class).selectValue(arg1, arg0);
        page.selectValue(element, value);

    }

    @Quando("^A página \"(.*)\" carregar$")
    public void aPaginaCarregar(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        BasePage.getInstance(MenuEditor.class).wait(500);
    }

    @Entao("^eu seleciono o valor \"([^\"]*)\" na lista$")
    public void euSelecionoOValorNaLista(String value) {

        ((ListElements) page).selectValueInList(value);
    }

    @Quando("^eu seleciono o valor \"([^\"]*)\" na lista \"([^\"]*)\"$")
    public void euSelecionoNaLista(String value, String list) {

        ((ListElements) page).selectValueInListWithList(value, list);
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
    public void euPreencherOCampoComOValor(String element, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        page.writeText(element, arg1);
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

    @E("^o valor do elemento na posição \"([^\"]*)\" é igual à \"([^\"]*)\"$")
    public void oValorDoElementoNaPosiçãoForIgualÀ(int position, String condition) {
        WebElement webElement = ((ListElements) page).selectValueInListByPosition(position);

        Assert.assertEquals(page.readText(webElement), condition);


    }

    @E("^eu clico duas vezes no elemento da posição \"([0-9]*)\"$")
    public void euClicoDuasVezesNoElementoDaPosição(int position) {
        ((ListElements) page).doubleClickInPosition(position);
    }

    @Então("^o elemento com o valor \"([^\"]*)\" \"(existe|nao existe)\" na lista \"([^\"]*)\"$")
    public void oElementoComOValorNãoExisteNaLista(String value, String condition, String list) throws BusinessException {
        ((ListElements) page).existElementWithValueInList(value, condition, list);
    }
}