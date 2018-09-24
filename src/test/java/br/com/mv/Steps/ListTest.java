package br.com.mv.Steps;

import br.com.mv.framework.ListElements;
import br.com.mv.framework.exceptions.BusinessException;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ListTest extends TestSteps {


    @Entao("^eu seleciono o valor \"([^\"]*)\" na lista$")
    public void euSelecionoOValorNaLista(String value) {

        ((ListElements) page).selectValueInList(value);
    }

    @Quando("^eu seleciono o valor \"([^\"]*)\" na lista \"([^\"]*)\"$")
    public void euSelecionoNaLista(String value, String list) {

        ((ListElements) page).selectValueInListWithList(value, list);
    }

    @Quando("^eu clico duas vezes no valor \"([^\"]*)\" na lista \"([^\"]*)\"$")
    public void euClicoDuasVezesNoValorNaLista(String value, String list) {
        ((ListElements) page).doubleClickInList(list, value);
    }

    @E("^o valor do elemento na posição \"([^\"]*)\" é igual à \"([^\"]*)\"$")
    public void oValorDoElementoNaPosicaoForIgualA(int position, String condition) {
        WebElement webElement = ((ListElements) page).selectValueInListByPosition(position);

        Assert.assertEquals(page.readText(webElement), condition);
    }

    @E("^eu clico duas vezes no elemento da posição \"([0-9]*)\"$")
    public void euClicoDuasVezesNoElementoDaPosicao(int position) {
        ((ListElements) page).doubleClickInPosition(position);
    }

    @Então("^o elemento com o valor \"([^\"]*)\" \"(existe|nao existe)\" na lista \"([^\"]*)\"$")
    public void oElementoComOValorNaoExisteNaLista(String value, String condition, String list) throws BusinessException {
        ((ListElements) page).existElementWithValueInList(value, condition, list);
    }

    @E("^eu clicar no elemento na posição \"(.*)\" da lista$")
    public void euClicarNoElementoNaPosicaoDaLista(int positon) {
        ((ListElements) page).clickInValueInListByPosition(positon);

    }
}
