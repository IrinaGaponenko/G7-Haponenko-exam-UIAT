package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.PageProvider;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    protected static PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp(){
        logger.info("-----Start" + testName.getMethodName() + "test-----");
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
        logger.info("The browser" + webDriver + "was opened");
        pageProvider = new PageProvider(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("The browser" + webDriver + "was closed");
        logger.info("-----End" + testName.getMethodName() + "test-----");
    }

    @Rule
    public TestName testName = new TestName();

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("safari".equalsIgnoreCase(browser)) {
            WebDriverManager.safaridriver().setup();
            webDriver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Can't init driver for browser " + browser);
        }
        return webDriver;
    }
}
