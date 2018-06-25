package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.Scenario
import cucumber.api.java.{After, Before}
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriverException}
import org.scalatest.time.{Millis, Seconds, Span}

import uk.gov.hmrc.integration.cucumber.utils.{Driver}

class Hooks extends CommonFunctions {

  @Before
  def setUp() {

    eventually(timeout(Span(60, Seconds)), interval(Span(5, Millis))) {
      delete all cookies
    }

    if(System.getProperty("zapEnabled", "false").toBoolean) {
      ZapScannerSteps initZapScanner
    }
  }

  @After
  def tearDown(scenario: Scenario) {
    if (scenario.isFailed) {
      Driver.instance.asInstanceOf[TakesScreenshot] match {
        case screenshot1: TakesScreenshot =>
          try {
            val screenshot = screenshot1.getScreenshotAs(OutputType.BYTES)
            scenario.embed(screenshot, "image/png")
          } catch {
            case somePlatformsDontSupportScreenshots: WebDriverException => System.err.println(somePlatformsDontSupportScreenshots.getMessage)
          }
        case _ =>
      }
    }
    delete all cookies
  }
}
