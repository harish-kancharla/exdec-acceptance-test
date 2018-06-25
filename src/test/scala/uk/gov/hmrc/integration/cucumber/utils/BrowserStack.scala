package uk.gov.hmrc.integration.cucumber.utils

import java.net.URL

import com.typesafe.config.ConfigFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.{DesiredCapabilities, RemoteWebDriver}

import scala.collection.JavaConversions._

object BrowserStack {

  private val projectName = "BBSI"
  private val buildName = "Local Build"

  private val defaultCapabilities: DesiredCapabilities = {
    new DesiredCapabilities(Map(
      "browserstack.debug" -> "true",
      "browserstack.local" -> "true",
      "project" -> projectName,
      "build" -> buildName))
  }

  private val loadedCapabilities: DesiredCapabilities = {
    sys.props.get("testDevice") match {
      case None => sys.error("'testDevice' property must be set to the name of a file in src/test/resources/browserstackdata.")
      case Some(name) => {
        val deviceConfig = ConfigFactory.parseResources(s"browserstackdata/$name.json")
        new DesiredCapabilities(deviceConfig.root().unwrapped())
      }
    }
  }

  def initialise(): WebDriver = {
    val config = ConfigFactory.parseResources("browserConfig.properties")
    val username = config.getString("username")
    val key = config.getString("automatekey")

    val capabilities = loadedCapabilities merge defaultCapabilities

    val url = new URL(s"http://$username:$key@hub-cloud.browserstack.com/wd/hub")

    val driver = new RemoteWebDriver(url, capabilities)
    driver
  }

}
