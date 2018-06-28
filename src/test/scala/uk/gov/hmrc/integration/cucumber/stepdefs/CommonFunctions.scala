package uk.gov.hmrc.integration.cucumber.stepdefs

import java.text.SimpleDateFormat
import java.util.Calendar

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.concurrent.Eventually
import org.scalatest.{Inside, Matchers}
import org.scalatest.selenium.WebBrowser
import uk.gov.hmrc.integration.cucumber.pages._
import uk.gov.hmrc.integration.cucumber.utils._

trait CommonFunctions extends ScalaDsl with EN with Matchers with WebBrowser with Inside with Eventually{

  implicit def driver = Driver.instance

  def pageMatch(page: String): PageObject = {
    page match {
      case "Authority Wizard" => homePage
    }
  }

  def assertNavigationToPage(page: PageObject) = {
    Waits.waitForUrlToBeVisible(page.pageUrl)
    currentUrl shouldBe page.pageUrl
    pageTitle shouldBe s"${page.pageTitle}"
  }

}
