package pages;

import libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class ParentPage extends ActionsWithElements{

    String BASE_URL;
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        BASE_URL = ConfigProvider.configProperties.base_url();
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("The site was opened " + url);
        } catch (Exception e) {
            logger.error("Can't open " + url);
            Assert.fail("Can't open " + url);
        }
    }

    abstract protected String getRelativeUrl();

    protected void checkUrl(String relativeUrl){
        Assert.assertEquals("Url is not expected", BASE_URL + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl(){
        checkUrl(getRelativeUrl());
    }

    protected void checkUrlWithPattern(String relativeUrl) {
        webDriverWait10.until(ExpectedConditions.urlMatches(BASE_URL + relativeUrl));
        Assert.assertTrue("Url is not expected \n"
                        + "Expected result: " + BASE_URL + relativeUrl + "\n"
                        + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(BASE_URL + relativeUrl));
    }

    protected void checkUrlWithPattern(){
        checkUrlWithPattern(getRelativeUrl());
    }
}
