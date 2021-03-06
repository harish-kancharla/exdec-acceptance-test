package uk.gov.hmrc.integration.cucumber.stepdefs

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait, _}
import im.mange.flakeless._
import uk.gov.hmrc.integration.cucumber.pages._

class CommonSteps extends CommonFunctions with BasePage {

  Given("""^I have been authenticated as a user$""") { () =>
    login()
  }

  And("""^I should be presented with "(.*)" page$""") { (page: String) =>
    assertNavigationToPage(pageMatch(page))
  }

  And("""^I select "(.*)" "(.*)"$""") { (option: String, eleType: String) =>
    //originally written
    clickElement(option)

  }

  And("""^Click "(.*)" button$""") { (button: String) =>
    clickOnButton(button)
  }

//  And("""^Click "(.*)" button$""") { (button: String) =>
//    clickOnButton("Start now")
//  }

  And("""^Click "(.*)" link$""") { (linkText: String) =>
    clickOn(DashboardPage.declarationField)
  }

  Then("""^I enter "(.*)" in "(.*)" page$""") { (ele: String, page:String) =>
    page match {
    //  case "submit" => textField(submitPage valueField) value = "123"
      case "consignment" => textField(consignmentPage ducrConsolidation) value = "5GB123456789000-123ABC456DEFIIIIIII"
      case "enter EORI" => textField(enterEORIPage valueField) value = "GB111222333444"
    }
  }

}