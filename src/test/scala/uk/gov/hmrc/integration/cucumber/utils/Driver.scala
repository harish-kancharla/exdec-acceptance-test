package uk.gov.hmrc.integration.cucumber.utils

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver

import scala.util.Try


object Driver extends BrowserFactory {

  if (mac){
    System.setProperty("webdriver.gecko.driver", s"$driverDirectoryMac/geckodriver")
  }
  else if(linux){
    System.setProperty("webdriver.gecko.driver", s"$driverDirectoryLinux/geckodriver")
  }
  else if(windows){
    System.setProperty("webdriver.gecko.driver", s"$driverDirectoryWindows/geckodriver.exe")
  }

  lazy val instance: WebDriver = {
    sys addShutdownHook {
      Try(instance.quit())
    }
    val selectedDriver: WebDriver = createBrowser

    selectedDriver
  }

  def setImplicitTimeout(selectedDriver: WebDriver, timeoutLength: Int) = {
    selectedDriver.manage().timeouts().implicitlyWait(timeoutLength, TimeUnit.SECONDS)
  }
}