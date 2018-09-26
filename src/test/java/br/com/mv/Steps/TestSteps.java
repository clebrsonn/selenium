package br.com.mv.Steps;

import br.com.mv.framework.BasePage;
import br.com.mv.framework.exceptions.BusinessException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

public class TestSteps {

    protected static BasePage page;

    private String pageTitle;


    public void setPage(String pageTitle) throws BusinessException {
        this.pageTitle = pageTitle;
        page = BasePage.getInstance(pageTitle);
    }



}
