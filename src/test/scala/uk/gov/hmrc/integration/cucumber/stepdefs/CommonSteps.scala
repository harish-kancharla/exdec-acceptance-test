package uk.gov.hmrc.integration.cucumber.stepdefs

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait, _}

class CommonSteps extends CommonFunctions {

  Given("""^open Authority Wizard$""") { () =>
    go to "https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in?continue=%2Fcustoms-declare-exports-frontend%2FselectRole"
  }

  Then("""^I should click submit at bottom of the page "([^"]*)" page$""") { (page:String) =>
    assertNavigationToPage(pageMatch(page))
  }
  And("""^Take me to Select Role page "([^"]*)" page$""") { (page: String) =>
    assertNavigationToPage(pageMatch(page))
  }

}
