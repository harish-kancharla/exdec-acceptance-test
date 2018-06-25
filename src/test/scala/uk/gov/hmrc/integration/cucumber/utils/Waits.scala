package uk.gov.hmrc.integration.cucumber.utils

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions

object Waits extends CommonFunctions{

  def waitForUrlToBeVisible(url: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 20)
    driverWait.until(ExpectedConditions.urlToBe(url))
  }

  def waitForElementToClickID(id: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 10)
    driverWait.until(ExpectedConditions.elementToBeClickable(By.id(id)))
  }

  def waitForElementToClickName(id: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 10)
    driverWait.until(ExpectedConditions.elementToBeClickable(By.name(id)))
  }

  def waitForElementToClickXpath(xpath: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 10)
    driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))
  }

  def waitForElementToClickLinkText(linkText: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 10)
    driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)))
  }

  def waitForElementToClickClassName(className: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 10)
    driverWait.until(ExpectedConditions.elementToBeClickable(By.className(className)))
  }

  def waitForElementToClicktagName(tagName: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 10)
    driverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)))
  }

  def waitForElementToPresent(id: String) = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 10)
    driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)))
  }
}
