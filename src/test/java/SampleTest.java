import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.openqa.selenium.WebDriver;
import com.saucelabs.junit.ConcurrentParameterized;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;
import java.util.LinkedList;

@RunWith(ConcurrentParameterized.class)
public class SampleTest {

    public static final String USERNAME = "claudia_alvarez";
    public static final String ACCESS_KEY = "5258476c-8610-48c5-a2f9-520c53084e73";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    protected String browser;
    protected String os;
    protected String version;
    protected WebDriver driver;

    public SampleTest(String os, String version, String browser) {
        super();
        this.os = os;
        this.version = version;
        this.browser = browser;
    }

    @ConcurrentParameterized.Parameters
    public static LinkedList<String[]> browsersStrings() {
        LinkedList<String[]> browsers = new LinkedList<String[]>();
        // windows 7, IE 9
        browsers.add(new String[]{"Windows 8", "50", "chrome"});
        // windows 8, IE 10
        browsers.add(new String[]{"Windows 8", "10", "internet explorer"});
        // windows 8.1, IE 11
        browsers.add(new String[]{"Windows 8.1", "11", "internet explorer"});

        return browsers;
    }

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM, os);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
    }

    @Test
    public void testCaseExample() {
        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());
        driver.quit();

    }



}
