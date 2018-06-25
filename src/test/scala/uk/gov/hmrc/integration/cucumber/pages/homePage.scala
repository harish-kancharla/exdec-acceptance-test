package uk.gov.hmrc.integration.cucumber.pages

import uk.gov.hmrc.integration.cucumber.stepdefs.CommonFunctions
import uk.gov.hmrc.integration.cucumber.utils.PageObject

object homePage extends PageObject with CommonFunctions{

  def pageUrl = "https://www.bbc.co.uk/"

  def pageHeading = ""

  def pageTitle = "BBC - Home"

}
