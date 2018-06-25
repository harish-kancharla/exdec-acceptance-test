package uk.gov.hmrc.integration.cucumber.stepdefs

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait, _}

class CommonSteps extends CommonFunctions {

  Given("""^open bbc website$""") { () =>
    go to "http://www.bbc.com"
  }

  Then("""^I should be presented with "([^"]*)" page$""") { (page:String) =>
    assertNavigationToPage(pageMatch(page))
  }

}
