package uk.gov.hmrc.integration.cucumber.utils

import java.net.URL

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeDriverService, ChromeOptions}
import org.openqa.selenium.firefox._
import org.openqa.selenium.remote.{DesiredCapabilities, RemoteWebDriver}

trait BrowserFactory {

  def getOs = System.getProperty("os.name")

  val mac = getOs.startsWith("Mac")
  val linux = getOs.startsWith("Linux")
  val windows = getOs.startsWith("Windows")

  def createBrowser: WebDriver = {
    val environmentProperty = System.getProperties.getProperty("browser", "firefox")
    environmentProperty match {
      case "firefox" => createFirefoxDriver
      case "chrome" => createChromeDriver
      case "browserstack" => BrowserStack.initialise()
      case _ => throw new IllegalArgumentException("Browser type not recognised")
    }
  }

  val driverDirectory = s"${System.getProperty("user.dir")}/src/test/resources/drivers"
  val driverDirectoryMac = s"${System.getProperty("user.dir")}/src/test/resources/drivers/mac"
  val driverDirectoryLinux = s"${System.getProperty("user.dir")}/src/test/resources/drivers/linux"
  val driverDirectoryWindows = s"${System.getProperty("user.dir")}/src/test/resources/drivers/windows"

  def createFirefoxDriver: WebDriver = {
    val options: FirefoxOptions = new FirefoxOptions()
    System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true")
    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null")
    val profile: FirefoxProfile = new FirefoxProfile
    profile.setPreference("javascript.enabled", true)
    profile.setAcceptUntrustedCertificates(true)

    if (System.getProperty("zapEnabled", "false").toBoolean) {
      profile.setPreference("network.proxy.type", 1)
      profile.setPreference("network.proxy.http", "localhost")
      profile.setPreference("network.proxy.http_port", 8090)
      profile.setPreference("network.proxy.share_proxy_settings", true)
      profile.setPreference("network.proxy.no_proxies_on", "")
    }

    options.setProfile(profile)
    options.setAcceptInsecureCerts(true)

    val driver = new FirefoxDriver(options)

    println(s"Browser: ${driver.getCapabilities.getBrowserName.capitalize} version.${driver.getCapabilities.getVersion}" + " " + s"OS: ${System.getProperty("os.name")}")

    driver
  }

  def createChromeDriver: WebDriver = {
    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, s"$driverDirectory/chromedriver")

    val options = new ChromeOptions()
    options.addArguments("--start-maximized")
    options.addArguments("test-type")
    options.addArguments("disable-infobars")

    val capabilities = DesiredCapabilities.chrome()
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)

    val driver = new ChromeDriver(capabilities)
    println(s"Browser: ${driver.getCapabilities.getBrowserName.capitalize} v.${driver.getCapabilities.getVersion}")

    driver.manage.window.maximize
    driver
  }

  def createRemoteDriver(caps: List[(String, String)]): WebDriver = {
    val USERNAME = "krishnaborra1"
    val AUTOMATE_KEY = "iKqS6cbqyxYS93Nxoj1b"
    val URL = s"http://$USERNAME:$AUTOMATE_KEY@hub-cloud.browserstack.com/wd/hub"

    val capabilities = new DesiredCapabilities
    for ((k, v) <- caps)
      capabilities.setCapability(k, v)
    capabilities.setJavascriptEnabled(true)
    capabilities.setCapability("project", "BBSI, Team 8")
    capabilities.setCapability("browserstack.local", "true")
    capabilities.setCapability("browserstack.debug", "true")

    capabilities.setCapability("build", "Local")
    new RemoteWebDriver(new URL(URL), capabilities)
  }
}
