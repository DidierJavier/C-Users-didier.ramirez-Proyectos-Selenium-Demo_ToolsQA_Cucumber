package co.com.sofka.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.python.antlr.ast.Str;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class SetupWebUI {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/webdriver/windows/chrome/chromedriver.exe";

    private static final String DEMO_QA_URL = "https://demoqa.com/automation-practice-form";

    protected WebDriver driver;

    protected void setUpWebDriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
        generalSetup();
    }

    private void generalSetup(){

        WebDriverManager.chromedriver().setup();//Para trabajar con el chrome driver actualizado

        driver = new ChromeDriver();

        driver.get(DEMO_QA_URL);

        driver.manage().window().maximize();
    }

    protected void setUpLog4j2(){

        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quiteDriver() {driver.quit();}
}
