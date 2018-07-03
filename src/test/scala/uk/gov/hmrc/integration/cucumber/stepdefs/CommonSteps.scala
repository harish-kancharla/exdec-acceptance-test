package uk.gov.hmrc.integration.cucumber.stepdefs

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait, _}
import im.mange.flakeless._

import uk.gov.hmrc.integration.cucumber.pages.BasePage

class CommonSteps extends CommonFunctions with BasePage{

  Given("""^I have been authenticated as a user$""") { () =>
    login()
  }

  And("""^I should be presented with "(.*)" page$""") { (page: String) =>
    assertNavigationToPage(pageMatch(page))
  }

  And("""^I select "(.*)" "(.*)"$""") { (option: String, eleType: String) =>
    //originally written
    clickElement(option)

    //using selenium webdriver
    //driver.findElement(By.id("selectRole.webLoaderArrivingGoods")).click()

    //using flakeless
//    val element: WebElement = driver.findElement(By.id("selectRole.webLoaderArrivingGoods"))
//    Click(element, By.id("selectRole.webLoaderArrivingGoods"))
  }

  And("""^Click "(.*)" button$""") { (button: String) =>
    clickOnButton("Save and continue")
  }

}
