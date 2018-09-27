package br.com.mv.Steps;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.ListElements;
import br.com.mv.framework.exceptions.BusinessException;
import cucumber.api.PendingException;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ListTest extends TestSteps {

    @Entao("^eu seleciono o valor \"([^\"]*)\" na lista$")
    public void euSelecionoOValorNaLista(String value) {

        ((ListElements) TestSteps.page).selectValueInList(value);
    }

    @Quando("^eu seleciono o valor \"([^\"]*)\" na lista \"([^\"]*)\"$")
    public void euSelecionoNaLista(String value, String list) {

        ((ListElements) TestSteps.page).selectValueInListWithList(value, list);
    }

    @Quando("^eu clico duas vezes no valor \"([^\"]*)\" na lista \"([^\"]*)\"$")
    public void euClicoDuasVezesNoValorNaLista(String value, String list) {
        ((ListElements) TestSteps.page).doubleClickInList(list, value);
    }

    @E("o valor do elemento na posição \"(\\d+)\" é igual à \"(.*)\"$")
    public void oValorDoElementoNaPosicaoForIgualA(int position, String condition) {
        WebElement webElement = ((ListElements) TestSteps.page).selectValueInListByPosition(position);

        Assert.assertEquals(TestSteps.page.readText(webElement), condition);
    }

    @E("eu clico duas vezes no elemento da posição \"(\\d+)\"")
    public void euClicoDuasVezesNoElementoDaPosicao(int position) {
        ((ListElements) TestSteps.page).doubleClickInPosition(position);
    }

    @Então("^o elemento com o valor \"([^\"]*)\" \"(existe|nao existe)\" na lista \"([^\"]*)\"$")
    public void oElementoComOValorNaoExisteNaLista(String value, String condition, String list) throws BusinessException {

        ((ListElements) BasePage.getInstance(list)).
                existElementWithValueInList(value, condition, BasePage.getInstance(list));
    }

    @E("eu clicar no elemento na posição \"(\\d+)\" da lista")
    public void euClicarNoElementoNaPosicaoDaLista(Integer positon) {
        ((ListElements) TestSteps.page).clickInValueInListByPosition(positon);
    }

}
