package uk.gov.hmrc.integration.cucumber.stepdefs

import java.text.SimpleDateFormat
import java.util.Calendar

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.concurrent.Eventually
import org.scalatest.{Inside, Matchers}
import org.scalatest.selenium.WebBrowser
import uk.gov.hmrc.integration.cucumber.pages._
import uk.gov.hmrc.integration.cucumber.utils._

trait CommonFunctions extends ScalaDsl with EN with Matchers with WebBrowser with Inside with Eventually {

  implicit def driver = Driver.instance

  def pageMatch(page: String): PageObject = {
    page match {
      case "Authority Wizard" => authLoginStubPage
      case "Select Role" => selectRolePage
      case "tech difficulties" => techDifficultiesPage
      case "consignment" => consignmentPage
      case "submit" => declarationsummaryPage
      case "Dashboard" => DashboardPage
      case "Export Declarations" => CustomsExportPage
      case "Own decalaration" => ownDescription
      case "Exporter representative" => representativePage
      case "enter EORI" => enterEORIPage
      case "Full export declaration" => representativesaddressPage

    }
  }

  def assertNavigationToPage(page: PageObject) = {
    Waits.waitForUrlToBeVisible(page.pageUrl)
    currentUrl shouldBe page.pageUrl
    pageTitle shouldBe s"${page.pageTitle}"
  }

  def login() = {
    go to authLoginStubPage.pageUrl
    authLogin()

  }

  def authLogin() = {
    textField(authLoginStubPage credIdField) value = "test"
    textField(authLoginStubPage enrolmentkeyField) value = "HMRC-CUS-ORG"
    textField(authLoginStubPage identifiernameField) value = "EORINUMBER"
    textField(authLoginStubPage identifiervalueField) value = "5643525643"

    // DropTargetDropEvent(authLoginStubPage statusDropdown) choose = "Activated"
    click on button
  }

  def button = className("button")

  def clickElement(ele: String) = {
    ele match {
      case "web loader arriving goods" => click on selectRolePage.selectRoleId
      case "Exporter making declaration" => click on selectRolePage.exporterMakingDecisionId
      case "consolidation" => click on consignmentPage.consigmentID
      case "declaration" => click on ownDescription.consigmentdeclarationID
      case "confirmation" => click on whosedeclarationPage.consigmentconfirmationID
      case "representative" => click on representativePage.representativeID
      case "Dashboard" => click on DashboardPage.declarationField
      case "enterEORI" => click on enterEORIPage.buttonID
      case "CustomsExport" => click on CustomsExportPage.startField


    }
  }


}





