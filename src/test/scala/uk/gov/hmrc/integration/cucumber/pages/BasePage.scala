package uk.gov.hmrc.integration.cucumber.pages

import java.util.concurrent.TimeUnit

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait, _}
import org.scalatest.selenium.WebBrowser
import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions


 trait BasePage extends CommonFunctions with WebBrowser {

  val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(20, TimeUnit.SECONDS)
    .pollingEvery(1, TimeUnit.SECONDS)

  val shortfluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(0, TimeUnit.SECONDS)
    .pollingEvery(1, TimeUnit.SECONDS)

  def environment = System.getProperty("environment", "Qa").toLowerCase

  def openPage(pageURL: String) {
    navigateToPage(pageURL)
    waitForPageToLoad(pageURL)
  }

  def getText(locator: By, expectedText: String) = {
    driver.findElement(locator).getText.contains(expectedText)
  }

  def getPageTitle = driver.getTitle

  def deleteCookies = {
    driver.manage().deleteAllCookies()
  }

  def browseBack = {
    driver.navigate().back()
  }

  def waitForPageToLoad(url: String) = fluentWait.until(ExpectedConditions.urlContains(url))

  def waitForPageToLoadByTitle(title: String) = fluentWait.until(ExpectedConditions.titleIs(title))

  def waitForElementVisible(element: WebElement) = fluentWait.until(ExpectedConditions.visibilityOf(element))

  def waitForElementInvisible(locator: By) = fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator))

  def waitForElementPresent(locator: By) = fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator))

  def clickOn(selector: By) = {
    waitForElementClickable(selector)
    driver.findElement(selector).click()
  }

  def clickOnButton(button: String) = {
    driver.findElement(By.xpath(s"//button[contains(text(),'$button')]")).click()
  }

  def waitForElementClickable(locator: By) = new WebDriverWait(driver, 20)
//  def waitForElementClickable(locator: By) = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator))

  def elementDisplayed(by: By): Boolean = {
    try {
      waitForElementVisible(by)
      true
    } catch {
      case e: NoSuchElementException => false
    }
  }

  def elementNotDisplayed(by: By): Boolean = {
    try {
      driver.manage.timeouts.implicitlyWait(0, TimeUnit.SECONDS)
      driver.findElement(by)
      false
    } catch {
      case e: NoSuchElementException => true
    }
    finally {
      driver.manage.timeouts.implicitlyWait(30, TimeUnit.SECONDS)
    }
  }

  def waitForElementVisible(locator: By) {
    fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator))
  }

  def textDisplayed(by: By, text: String): Boolean = {
    try {
      waitForElementVisible(by)
      textFromElement(by).equals(text)
      true
    } catch {
      case e: NoSuchElementException => false
    }
  }

  def textFromElement(selector: By) = {
    waitForElementVisible(selector)
    driver.findElement(selector).getText
  }

  def checkElementExists(selector: By): Boolean = {
    if (driver.findElements(selector).size() != 0)
      return true
    else
      return false
  }

  def navigateToPage(url: String) {
    go to url
  }

  def sendKeys(selector: By, value: String) = {
    waitForElementVisible(selector)
    driver.findElement(selector).clear()
    driver.findElement(selector).sendKeys(value)
    // Stale element Exception workaround
    //    driver.findElement(selector).sendKeys(Keys.TAB)
  }

  def selectRadioOption(selector: By) = {

  }

  def enterText(selector: By, value: String) = {
     sendKeys(selector, value.trim)
  }

  def verifyLiteralText(selector: By, textToConfirm: String) {
    assert(driver.findElement(selector).getText.contains(textToConfirm))
  }

  def randomString(alphabets: String)(n: Int): String = {
    val random = new scala.util.Random
    Stream.continually(random.nextInt(alphabets.size)).map(alphabets).take(n).mkString
  }

  def generateRandomNino: String = {
    val ninoNumbers = randomString("1234567890132456475645643545646545644")(6)
    val nino: String = "SJ" + ninoNumbers + "B"
    nino
  }

  def selectDropdown(selector: By, value: String) = {
    val dropdown = new Select(driver.findElement(selector))
    dropdown.selectByVisibleText(value)
  }

  def generateThisLengthIncludingTheseCharacters(includingChars: String, n: Int): String = {
    includingChars + randomString("1234567890bajkfbfvjkabvjkafkjbfvkjaaffvbkfafvbjkeaffvjkbeafjkfvbjkefbvkvbeajkfbfvjkbefvjbvjkefbvjkvbef")(n)
  }

  def generateRandomNumeric(n: Int): String = {
    randomString("1234567890")(n)
  }

  def clickButton(selector: By) = {
    jumpToElement(selector)
    clickElement(selector, Keys.RETURN)
  }
  private def jumpToElement(el: By)(implicit driver: WebDriver): WebElement = {
    val element: WebElement = driver.findElement(el)
    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(el))
    element
  }
  private def clickElement(el: By, keys: CharSequence*)(implicit driver: WebDriver): Unit = {
    val element = jumpToElement(el)
    element.sendKeys(keys: _*)
  }
}