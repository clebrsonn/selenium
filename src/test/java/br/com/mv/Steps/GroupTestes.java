package br.com.mv.Steps;

import br.com.mv.framework.exceptions.BusinessException;
import cucumber.api.PendingException;
import cucumber.api.java.pt.*;
import org.junit.Assert;


public class GroupTestes extends TestSteps {

    @Quando("^eu vou a pagina \"([^\"]*)\"$")
    @Dado("^eu vou a pagina de \"(.*)\"$")
    public void queEuVouAPagina(String pageTitle) throws BusinessException {
        setPage(pageTitle);

    }


    @Então("^Eu logo na aplicação$")
    public void euLogoNaAplicacao() {
        // Write code here that turns the phrase above into concrete actions
        // page.getInstance(LoginPage.class).logar();
    }

    @E("^eu clico no \"(.*)\"$")
    @Quando("^eu clicar no \"(.*)\"$")
    public void euClicarNo(String element) {
        TestSteps.page.click(element);
    }

    @Quando("^o elemento \"(.*)\" carregar$")
    public void oElementoCarregar(String element) {
        TestSteps.page.isPresent(element);
    }


    @E("^eu clicar no \"(.*)\" no \"(.*)\" combobox$")
    @Entao("^eu seleciono o valor \"(.*)\" no \"([^\"]*)\" combobox$")
    public void euSelecionoOValorNoCombobox(String value, String element) {

        TestSteps.page.selectValue(element, value);

    }

    @Quando("^A página \"(.*)\" carregar$")
    public void aPaginaCarregar(String arg0) {
        // Write code here that turns the phrase above into concrete actions
//        BaseTestSteps.page.getInstance(MenuEditor.class).wait(500);
    }


    //Condition equals ativo or inativo
    @Quando("^o elemento \"([^\"]*)\" estiver \"(inativo|ativo)\"$")
    public void oElementoEstiver(String element, String condition) throws Exception {
        TestSteps.page.isActive(element, condition);

    }

    @Então("^o elemento \"(.*)\" está \"(visivel|invisivel)\"$")
    public void ElementoVisivel(String element, String condition) {
        TestSteps.page.isVisible(element, condition);

    }

    @E("^eu preencher o campo \"([^\"]*)\" com o valor \"([^\"]*)\"$")
    public void euPreencherOCampoComOValor(String element, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        TestSteps.page.writeText(element, arg1);
    }

    @E("^eu espero o elemento \"([^\"]*)\" ficar \"(visivel|invisivel)\"$")
    public void euEsperoOElementoFicar(String element, String condition) {
        // Write code here that turns the phrase above into concrete actions
        TestSteps.page.isVisible(element, condition);
    }

    @E("^eu clicar duas vezes no elemento \"(.*)\"$")
    @Quando("^eu clico duas vezes no elemento \"(.*)\"$")
    public void euClicoDuasVezesNoElemento(String element) {
        TestSteps.page.doubleClick(element);
    }


    @Então("^o texto do elemento \"(.*)\" for igual à \"(.*)\"$")
    @E("^o valor do elemento \"(.*)\" for igual à \"(.*)\"$")
    public void oValorDoElementoForIgualA(String element, String condition) {
        Assert.assertEquals(TestSteps.page.readText(element), condition);
    }


}